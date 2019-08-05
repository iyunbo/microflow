package org.iyunbo.microflow.service;

import java.util.Map;

public interface WordCounter {
	Map<String, Long> countWords(final String path);
}
