package com.kalachev.task5;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConsloleResultPrinter {
	static final String NEWLINE = System.lineSeparator();



	public String printUniquesCharsAmounts(String input) {
			UniqueCharactersCalculator uniqueCharactersCalculator = new UniqueCharactersCalculator();
			LinkedHashMap<Character, Integer> uniqCharactersWithAmounts = uniqueCharactersCalculator.convertInput(input);
			StringBuilder sb = new StringBuilder();
			sb.append(input);
			if (!input.isEmpty()) {
				sb.append(NEWLINE);
			}
			sb.append(convertData(uniqCharactersWithAmounts));
			return sb.toString();

	}

	private String convertData(LinkedHashMap<Character, Integer> charsCollection) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Character, Integer> entry : charsCollection.entrySet()) {
			sb.append("\"" + entry.getKey() + "\"" + " - " + entry.getValue() + NEWLINE);
		}
		return sb.toString();
	}

}