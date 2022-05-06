package com.kalachev.task5;

import java.util.LinkedHashMap;

public class UniqueCharacters {
	
	
	public LinkedHashMap<Character, Integer> calculateUniqueCharsAmount(String input) {
		checkForNullOrEmpty(input);
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
	
	private void checkForNullOrEmpty(String input) {
		if((input == null) || (input.isEmpty())) {
			throw new IllegalArgumentException();
		}
	}
}

