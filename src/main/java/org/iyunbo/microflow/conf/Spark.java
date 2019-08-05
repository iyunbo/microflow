package org.iyunbo.microflow.conf;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

import java.io.IOException;
import java.util.Properties;

public class Spark {

	private static JavaSparkContext sparkS3;

	public static synchronized JavaSparkContext sc() {
		if (sparkS3 == null) {
			sparkS3 = sparkOverS3();
		}
		return sparkS3;
	}

	private static JavaSparkContext sparkOverS3() {
		Properties env = loadEnvironment();
		final SparkConf conf = sparkConf(env.getProperty("spark.app.name"),
				env.getProperty("spark.master"),
				env.getProperty("s3.access.id"),
				env.getProperty("s3.access.key"));
		return sparkContext(conf);
	}

	private static SparkConf sparkConf(String appName, String masterUri, String id, String key) {
		return new SparkConf()
				.setAppName(appName)
				.set("spark.hadoop.fs.s3a.access.key", id)
				.set("spark.hadoop.fs.s3a.secret.key", key)
				.setMaster(masterUri);
	}

	private static Properties loadEnvironment() {
		Properties properties = new Properties();
		try {
			properties.load(Spark.class.getClassLoader().getResourceAsStream("spark.properties"));
		} catch (IOException e) {
			throw new IllegalStateException("cannot load file: spark.properties", e);
		}
		return properties;
	}

	private static JavaSparkContext sparkContext(SparkConf sparkConf) {
		return new JavaSparkContext(sparkConf);
	}

}