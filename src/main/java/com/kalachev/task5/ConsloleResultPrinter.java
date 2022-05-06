package com.kalachev.task5;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConsloleResultPrinter {
	static final String NEWLINE = System.lineSeparator();
	Cache<String, LinkedHashMap<Character, Integer>> cache;

	public ConsloleResultPrinter() {
		super();
		this.cache = new LruCache<>(3);
	}

	public Cache<String, LinkedHashMap<Character, Integer>> getCache() {
		return cache;
	}


	public String printUniquesCharsAmounts(String input) {
		if (cache.containsKey(input)) {
			return convertData(cache.get(input));
		} else {
			UniqueCharacters uniqueCharacters = new UniqueCharacters();
			LinkedHashMap<Character, Integer> uniqCharactersMap = uniqueCharacters.calculateUniqueCharsAmount(input);
			StringBuilder sb = new StringBuilder();
			sb.append(input);
			if (!input.isEmpty()) {
				sb.append(NEWLINE);
			}
			sb.append(convertData(uniqCharactersMap));
			cache.put(input, uniqCharactersMap);
			return sb.toString();

		}
	}

	private String convertData(LinkedHashMap<Character, Integer> charsCollection) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Character, Integer> entry : charsCollection.entrySet()) {
			sb.append("\"" + entry.getKey() + "\"" + " - " + entry.getValue() + NEWLINE);
		}
		return sb.toString();
	}

}
