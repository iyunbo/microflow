package org.iyunbo.microflow.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.Map;

@Slf4j
public class SparkWordService {

	private final JavaSparkContext sparkContext;

	public SparkWordService(final JavaSparkContext sparkContext) {
		this.sparkContext = sparkContext;
	}

	public Map<String, Long> countWords(final String url) {
		log.info("accessing {}", url);
		final JavaRDD<String> words = sparkContext.textFile(url)
				.map(line -> line.replaceAll("[^a-zA-Z0-9\\s]", ""))
				.map(String::toLowerCase)
				.map(sentence -> sentence.split("\\s+"))
				.flatMap(w -> Arrays.asList(w).iterator())
				.filter(w -> !w.isEmpty());
		return words.countByValue();
	}
}
