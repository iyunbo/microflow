package org.iyunbo.microflow.service;

import java.util.Map;

public interface WordService {
	Map<String, Long> countWords(final String path);
}
