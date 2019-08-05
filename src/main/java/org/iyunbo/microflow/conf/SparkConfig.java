package org.iyunbo.microflow.conf;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:secret.properties")
public class SparkConfig {

	@Bean
	public SparkConf conf(@Value("${spark.app.name}") String appName,
	                      @Value("${spark.master}") String masterUri,
	                      @Value("${spark.hadoop.fs.s3a.access.key}") String id,
	                      @Value("${spark.hadoop.fs.s3a.secret.key}") String key) {
		return new SparkConf()
				.setAppName(appName)
				.set("spark.hadoop.fs.s3a.access.key", id)
				.set("spark.hadoop.fs.s3a.secret.key", key)
				.setMaster(masterUri);
	}

	@Bean
	public JavaSparkContext sparkContext(SparkConf sparkConf) {
		return new JavaSparkContext(sparkConf);
	}

}