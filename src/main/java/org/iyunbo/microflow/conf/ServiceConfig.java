package org.iyunbo.microflow.conf;

import org.apache.spark.api.java.JavaSparkContext;
import org.iyunbo.microflow.service.SparkWordService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

	@Bean
	public SparkWordService wordService(final JavaSparkContext sparkContext) {
		return new SparkWordService(sparkContext);
	}

}
