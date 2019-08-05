package org.iyunbo.microflow.service;

import org.iyunbo.microflow.service.impl.LocalFileWordProcessor;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalFileWordCounterTest {
	private WordCounter wordCounter = new LocalFileWordProcessor();

	@Test
	public void should_count_words() {
		assertThat(wordCounter.countWords("message.txt"))
				.hasSizeGreaterThan(3)
				.containsKeys("this", "is", "a", "sentence");
	}
}