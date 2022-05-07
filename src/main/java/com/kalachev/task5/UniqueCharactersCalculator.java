package com.kalachev.task5;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UniqueCharactersCalculator {
	Cache<String, LinkedHashMap<Character, Integer>> cache;
	
	public UniqueCharactersCalculator() {
		super();
		this.cache = new LruCache<>(3);
	}

	public Cache<String, LinkedHashMap<Character, Integer>> getCache() {
		return cache;
	}
	
	public LinkedHashMap<Character, Integer> convertInput(String input) {
		LinkedHashMap<Character, Integer> uniqCharactersMap = new LinkedHashMap<>();
		List<Character> chars = input.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
		chars.forEach(c -> uniqCharactersMap.merge(c, 1, (prev, one) -> prev + one));
		return uniqCharactersMap;
	}

	public Map<Character, Integer> convertAndCacheInput(String input) {
		checkForNullOrEmpty(input);
		if (cache.containsKey(input)) {
			return cache.get(input);
		}
		else {
			cache.put(input, convertInput(input));
			return convertInput(input);
		}
	}

	private void checkForNullOrEmpty(String input) {
		if ((input == null) || (input.isEmpty())) {
			throw new IllegalArgumentException();
		}
	}
}
