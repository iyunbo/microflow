package org.iyunbo.microflow.service;

import java.util.Map;

public interface WordComputation {
	Map<String, Long> countWords(final String path);
}
