package com.kalachev.task5;

import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueCharacters {
	static final String NEWLINE = System.lineSeparator();
	private StringBuilder createdOutoutSourcesString;

	public UniqueCharacters() {
		this.createdOutoutSourcesString = new StringBuilder();
	}
	
	public String printUniqs(String input, Cache lru) throws IllegalArgumentException {
		checkForNull(input);
		if (lru.getCache().containsKey(input)) {
			createdOutoutSourcesString.append(getCacheSource(input));
			return lru.getCache().get(input);
		} else {
			String printedOutputString = doThePrint(input);
			lru.add(input,printedOutputString);
			createdOutoutSourcesString.append(getCalculationSource(input));
			return printedOutputString;
		}
	}
	
	public String outputSourseHistory() {
		return createdOutoutSourcesString.toString();
	}
	
	private LinkedHashMap<Character, Integer> createOutputMap(String input) {
		LinkedHashMap<Character, Integer> uniqCharactersMap = new LinkedHashMap<>();
		for (Character c : input.toCharArray()) {
			if (!uniqCharactersMap.containsKey(c)) {
				uniqCharactersMap.put(c, 1);
			} else {
				uniqCharactersMap.put(c, uniqCharactersMap.get(c) + 1);
			}
		}
		return uniqCharactersMap;
	}
	
	private String doThePrint(String input) {
		LinkedHashMap<Character, Integer> uniqCharactersMap = createOutputMap(input);
		StringBuilder sb = new StringBuilder();
		sb.append(input);
		if(!input.isEmpty()) {
			sb.append(NEWLINE);
		}
		for (Map.Entry<Character, Integer> entry : uniqCharactersMap.entrySet()) {
			sb.append("\"" + entry.getKey() + "\"" + " - " + entry.getValue() + NEWLINE);
		}
		return sb.toString();
	}

	private String getCacheSource(String input) {
		return input +NEWLINE + "this string was outputed from cache" + NEWLINE;
	}
	private String getCalculationSource(String input) {
		return input +NEWLINE + "this string was outputed from calculations" + NEWLINE;
	}
	
	private void checkForNull(String input) {
		if(input == null) {
			throw new IllegalArgumentException();
		}
	}
}

