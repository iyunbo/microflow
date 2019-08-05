package org.iyunbo.microflow.service;

import org.iyunbo.microflow.service.impl.BigDataWordProcessor;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BigDataWordComputationTest {
	private WordComputation wordComputation = new BigDataWordProcessor();

	@Test
	public void should_count_words() {
		assertThat(wordComputation.countWords("message.txt"))
				.hasSizeGreaterThan(100)
				.containsKeys("according", "for", "see", "hallo");
	}
}