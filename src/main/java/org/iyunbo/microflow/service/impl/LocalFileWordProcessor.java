package org.iyunbo.microflow.service.impl;

import org.iyunbo.microflow.service.WordService;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LocalFileWordProcessor implements WordService {
	private final ClassLoader classLoader = getClass().getClassLoader();

	@Override
	public Map<String, Long> countWords(String path) {
		try {

			final URI uri = Objects.requireNonNull(classLoader.getResource(path)).toURI();

			final Stream<String> stream = Files.lines(Paths.get(uri));
			return stream.map(String::toLowerCase)
					.map(line -> line.replaceAll("[^a-z0-9\\s]", ""))
					.map(sentence -> sentence.split("\\s+"))
					.flatMap(Stream::of)
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		} catch (IOException | URISyntaxException e) {
			throw new IllegalStateException("Failed to load file: " + path, e);
		}
	}
}
