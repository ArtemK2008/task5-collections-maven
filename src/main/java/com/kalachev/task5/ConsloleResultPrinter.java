package com.kalachev.task5;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConsloleResultPrinter {
	static final String NEWLINE = System.lineSeparator();
	
	 public String printUniquesCharsAmounts(String input) {
		 UniqueCharacters uniqueCharacters = new UniqueCharacters();
		 LinkedHashMap<Character, Integer> uniqCharactersMap = uniqueCharacters.calculateUniqueCharsAmount(input);
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
	
}
