package org.iyunbo.microflow.service.impl;

import java.util.Map;

public interface WordService {
	Map<String, Long> countWords(final String path);
}
