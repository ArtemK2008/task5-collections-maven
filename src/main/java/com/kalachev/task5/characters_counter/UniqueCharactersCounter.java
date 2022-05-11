package com.kalachev.task5.characters_counter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.kalachev.task5.cache.Cache;
import com.kalachev.task5.cache.LruCache;

public class UniqueCharactersCounter {
	Cache<String, LinkedHashMap<Character, Integer>> cache;
	
	public UniqueCharactersCounter() {
		super();
		this.cache = new LruCache<>(3);
	}

	public Cache<String, LinkedHashMap<Character, Integer>> getCache() {
		return cache;
	}
	
	
	private LinkedHashMap<Character, Integer> countUniqsInInput(String input) {
		LinkedHashMap<Character, Integer> uniqCharactersMap = new LinkedHashMap<>();
		List<Character> chars = input.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
		chars.forEach(c -> uniqCharactersMap.merge(c, 1, (prev, one) -> prev + one));
		return uniqCharactersMap;
	}

	public LinkedHashMap<Character, Integer> calculateCharactersForOutput(String input) {
		checkForNullOrEmpty(input);
		if (cache.containsKey(input)) {
			return cache.get(input);
		}
		else {
			cache.put(input, countUniqsInInput(input));
			return countUniqsInInput(input);
		}
	}

	private void checkForNullOrEmpty(String input) {
		if ((input == null) || (input.isEmpty())) {
			throw new IllegalArgumentException();
		}
	}
}
