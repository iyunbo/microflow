package org.iyunbo.microflow.service;

import org.iyunbo.microflow.conf.ServiceConfig;
import org.iyunbo.microflow.conf.SparkConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SparkConfig.class, ServiceConfig.class})
public class WordServiceTest {
	@Autowired
	private SparkWordService sparkWordService;

	@Test
	public void should_count_words() {
		assertThat(sparkWordService.countWords("s3a://microflow/data/message.txt"))
				.hasSizeGreaterThan(100)
				.containsKeys("according", "for", "see", "hallo");
	}
}