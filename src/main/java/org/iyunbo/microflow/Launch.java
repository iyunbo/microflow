package org.iyunbo.microflow;

import lombok.extern.slf4j.Slf4j;
import org.iyunbo.microflow.service.WordCounter;
import org.iyunbo.microflow.service.impl.BigDataWordProcessor;

import java.util.Map;

@Slf4j
public class Launch {

	public static void main(final String[] args) {
		final WordCounter wordCounter = new BigDataWordProcessor();
		Map<String, Long> result = wordCounter.countWords("message.txt");
		log.info("word frequencies: {}", result);
	}
}
