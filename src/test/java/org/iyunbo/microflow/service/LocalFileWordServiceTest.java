package org.iyunbo.microflow.service;

import org.iyunbo.microflow.service.impl.LocalFileWordProcessor;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalFileWordServiceTest {
	private WordService wordService = new LocalFileWordProcessor();

	@Test
	public void should_count_words() {
		assertThat(wordService.countWords("message.txt"))
				.hasSizeGreaterThan(3)
				.containsKeys("this", "is", "a", "sentence");
	}
}