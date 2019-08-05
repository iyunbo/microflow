package org.iyunbo.microflow.service;

import org.iyunbo.microflow.service.impl.BigDataWordProcessor;
import org.iyunbo.microflow.service.impl.WordService;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WordServiceTest {
	private WordService wordService = new BigDataWordProcessor();

	@Test
	public void should_count_words() {
		assertThat(wordService.countWords("message.txt"))
				.hasSizeGreaterThan(100)
				.containsKeys("according", "for", "see", "hallo");
	}
}