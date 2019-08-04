package org.iyunbo.microflow.service;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.Map;

public class WordService {

	private final JavaSparkContext sparkContext;

	public WordService(final JavaSparkContext sparkContext) {
		this.sparkContext = sparkContext;
	}

	public Map<String, Long> getCount(final String wordList) {
		JavaRDD<String> words = sparkContext.parallelize(Arrays.asList(wordList.split("\\s+")));
		return words.countByValue();
	}
}
