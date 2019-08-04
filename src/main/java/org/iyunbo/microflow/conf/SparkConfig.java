package org.iyunbo.microflow.conf;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SparkConfig {

	@Bean
	public SparkConf conf(@Value("${spark.app.name}") String appName,
	                      @Value("${spark.master}") String masterUri) {
		return new SparkConf().setAppName(appName).setMaster(masterUri);
	}

	@Bean
	public JavaSparkContext sparkContext(SparkConf sparkConf) {
		return new JavaSparkContext(sparkConf);
	}

}