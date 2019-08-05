package org.iyunbo.microflow.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.iyunbo.microflow.conf.Spark;
import org.iyunbo.microflow.service.WordService;

import java.util.Arrays;
import java.util.Map;

@Slf4j
public class BigDataWordProcessor implements WordService {

	private static final String S3_PREFIX = "s3a://microflow/data";
	private static final String S3_SEPARATOR = "/";
	private final JavaSparkContext sparkContext;

	public BigDataWordProcessor() {
		this.sparkContext = Spark.sc();
	}

	public Map<String, Long> countWords(final String path) {
		final String url = String.join(S3_SEPARATOR, S3_PREFIX, path);
		log.info("accessing s3 file: {}", url);

		final JavaRDD<String> words = sparkContext.textFile(url)
				.map(String::toLowerCase)
				.map(line -> line.replaceAll("[^a-z0-9\\s]", ""))
				.map(sentence -> sentence.split("\\s+"))
				.flatMap(w -> Arrays.asList(w).iterator())
				.filter(w -> !w.isEmpty());

		return words.countByValue();
	}
}
