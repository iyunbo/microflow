package org.iyunbo.microflow.conf;

import org.apache.spark.api.java.JavaSparkContext;
import org.iyunbo.microflow.service.WordService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

	@Bean
	public WordService wordService(final JavaSparkContext sparkContext) {
		return new WordService(sparkContext);
	}

}
