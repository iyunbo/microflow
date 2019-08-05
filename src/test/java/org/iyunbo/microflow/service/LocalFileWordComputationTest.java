package org.iyunbo.microflow.service;

import org.iyunbo.microflow.service.impl.LocalFileWordProcessor;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalFileWordComputationTest {
	private WordComputation wordComputation = new LocalFileWordProcessor();

	@Test
	public void should_count_words() {
		assertThat(wordComputation.countWords("message.txt"))
				.hasSizeGreaterThan(3)
				.containsKeys("this", "is", "a", "sentence");
	}
}