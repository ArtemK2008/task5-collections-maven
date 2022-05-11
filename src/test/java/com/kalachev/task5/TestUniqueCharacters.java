package com.kalachev.task5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.kalachev.task5.characters_counter.ConsloleResultPrinter;
import com.kalachev.task5.characters_counter.UniqueCharactersCounter;

class TestUniqueCharacters {

	static final String NEWLINE = System.lineSeparator();
	
	@Test
	void printUniques_shouldReturnIlligalArgumentException_whenInpuIsNull() {
    UniqueCharactersCounter calc = new UniqueCharactersCounter();
    String NULL= null;
	     assertThrows(IllegalArgumentException.class, () -> calc.calculateCharactersForOutput(NULL));
	}
	
	@Test
	void printUniques_shouldPrintUniqueCharsAndItsAmount_whenEmptyInput() {
		UniqueCharactersCounter calc = new UniqueCharactersCounter();	  
		String EMPTY= "";
	     assertThrows(IllegalArgumentException.class, () -> calc.calculateCharactersForOutput(EMPTY));
}
	
	@Test
	void printUniques_shouldPrintUniqueCharsAndItsAmount_whenInput0() {
		ConsloleResultPrinter resultPrinter = new ConsloleResultPrinter();
		String INPUT0 = "hello word!";
		
	  String expected = String.format
			  ("hello word!%n" +
	           "\"h\" - 1%n" +
	           "\"e\" - 1%n" +
	           "\"l\" - 2%n" +
	           "\"o\" - 2%n" +
	           "\" \" - 1%n" +
	           "\"w\" - 1%n" +
	           "\"r\" - 1%n" +
	           "\"d\" - 1%n" +
	           "\"!\" - 1%n");
	  String actual = resultPrinter.printUniquesCharsAmounts(INPUT0);
	  assertEquals(expected, actual);
}
	@Test
	void printUniques_shouldPrintUniqueCharsAndItsAmount_whenInput1() {
		ConsloleResultPrinter resultPrinter = new ConsloleResultPrinter();
		String INPUT1 = "doing tests";
	  
	  String expected = String.format
			  ("doing tests%n" +
	           "\"d\" - 1%n" +
	           "\"o\" - 1%n" +
	           "\"i\" - 1%n" +
	           "\"n\" - 1%n" +
	           "\"g\" - 1%n" +
	           "\" \" - 1%n" +
	           "\"t\" - 2%n" +
	           "\"e\" - 1%n" +
	           "\"s\" - 2%n");
	  String actual = resultPrinter.printUniquesCharsAmounts(INPUT1);
	  assertEquals(expected, actual);
}
	
	@Test
	void printUniques_shouldPrintUniqueCharsAndItsAmount_whenInput2() {
		ConsloleResultPrinter resultPrinter = new ConsloleResultPrinter();
		String INPUT2 = "is it working?";
	  String expected = String.format
			  ("is it working?%n" +
	           "\"i\" - 3%n" +
	           "\"s\" - 1%n" +
	           "\" \" - 2%n" +
	           "\"t\" - 1%n" +
	           "\"w\" - 1%n" +
	           "\"o\" - 1%n" +
	           "\"r\" - 1%n" +
	           "\"k\" - 1%n" +
	           "\"n\" - 1%n" +
	           "\"g\" - 1%n" +
			   "\"?\" - 1%n");
	  String actual = resultPrinter.printUniquesCharsAmounts(INPUT2);
	  assertEquals(expected, actual);
}
	@Test
	void printUniques_shouldPrintUniqueCharsAndItsAmount_whenInput3() {
		ConsloleResultPrinter resultPrinter = new ConsloleResultPrinter();
		String INPUT3 = "printing uniques correctly?";
	  
	  String expected = String.format
			  ("printing uniques correctly?%n" +
	           "\"p\" - 1%n" +
	           "\"r\" - 3%n" +
	           "\"i\" - 3%n" +
	           "\"n\" - 3%n" +
	           "\"t\" - 2%n" +
	           "\"g\" - 1%n" +
	           "\" \" - 2%n" +
	           "\"u\" - 2%n" +
	           "\"q\" - 1%n" +
	           "\"e\" - 2%n" +
			   "\"s\" - 1%n" +
			   "\"c\" - 2%n" +
			   "\"o\" - 1%n" +
			   "\"l\" - 1%n" +
			   "\"y\" - 1%n" +
			   "\"?\" - 1%n") ;
	  String actual = resultPrinter.printUniquesCharsAmounts(INPUT3);
	  assertEquals(expected, actual);
}
	@Test
	void printUniques_shouldPrintUniqueCharsAndItsAmount_whenInput4() {
		ConsloleResultPrinter resultPrinter = new ConsloleResultPrinter();
		String INPUT4 = "and what about cash?";
	  
	  String expected = String.format
			  ("and what about cash?%n" +
	           "\"a\" - 4%n" +
	           "\"n\" - 1%n" +
	           "\"d\" - 1%n" +
	           "\" \" - 3%n" +
	           "\"w\" - 1%n" +
	           "\"h\" - 2%n" +
	           "\"t\" - 2%n" +
	           "\"b\" - 1%n" +
	           "\"o\" - 1%n" +
	           "\"u\" - 1%n" +
			   "\"c\" - 1%n" +
			   "\"s\" - 1%n" +
			   "\"?\" - 1%n" 
			   ) ;
	  String actual = resultPrinter.printUniquesCharsAmounts(INPUT4);
	  assertEquals(expected, actual);
}
	
	@Test 
	void checkCacheInserting_shouldStoreOneElement_whenOnlyOneStringInApp() {
		UniqueCharactersCounter calc = new UniqueCharactersCounter();
		String INPUT0 = "hello word!";
		  
		calc.calculateCharactersForOutput(INPUT0);
		  List<String> expected = new ArrayList<String>(); 
		  expected.add(INPUT0);
		  List<String> actual = calc.getCache().cacheContent();
		  assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
	}
	
	
	@Test 
	void checkCacheInserting_shouldStoreMostRecentElement_whenTwoInputs() {
	   	UniqueCharactersCounter calc = new UniqueCharactersCounter();
	   	String INPUT0 = "hello word!";
	   	String INPUT1 = "doing tests";
	     calc.calculateCharactersForOutput(INPUT0);
	     calc.calculateCharactersForOutput(INPUT1);
		 List<String> expected = new ArrayList<String>(); 
		  expected.add(INPUT1);
		  expected.add(INPUT0);
		  List<String> actual = calc.getCache().cacheContent();
		  assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
	}
	
	@Test 
	void checkCacheInserting_shouldStoreMostRecentElement_whenFiveInputs() {
		UniqueCharactersCounter calc = new UniqueCharactersCounter();
		String INPUT0 = "hello word!";
		String INPUT1 = "doing tests";
		String INPUT2 = "is it working?";
		String INPUT3 = "printing uniques correctly?";
		String INPUT4 = "and what about cash?";
		calc.calculateCharactersForOutput(INPUT0);
		calc.calculateCharactersForOutput(INPUT1);
		calc.calculateCharactersForOutput(INPUT2);
		calc.calculateCharactersForOutput(INPUT3);
		calc.calculateCharactersForOutput(INPUT4);
		 List<String> expected = new ArrayList<String>(); 
		  expected.add(INPUT4);
		  expected.add(INPUT2);
		  expected.add(INPUT3);
		  List<String> actual = calc.getCache().cacheContent();
		  assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
	}
	
	
	@Test 
	void checkCacheInserting_shouldOneElement_WhenfiveSameInputsWereGiven() {
		UniqueCharactersCounter calc = new UniqueCharactersCounter();
		String INPUT0 = "hello word!";
		calc.calculateCharactersForOutput(INPUT0);
		calc.calculateCharactersForOutput(INPUT0);
		calc.calculateCharactersForOutput(INPUT0);
		calc.calculateCharactersForOutput(INPUT0);
		calc.calculateCharactersForOutput(INPUT0);
		 List<String> expected = new ArrayList<String>(); 
		  expected.add(INPUT0);
		  List<String> actual = calc.getCache().cacheContent();
		  assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
	}
	

	@Test 
	void checkCacheInserting_shouldFigureOutputSourceCorrectly_WhenSameInputsOccur() {
		UniqueCharactersCounter calc = new UniqueCharactersCounter();
		String INPUT0 = "hello word!";
		String INPUT1 = "doing tests";
		String INPUT2 = "is it working?";
		String INPUT3 = "printing uniques correctly?";
		     calc.calculateCharactersForOutput(INPUT0);
	         calc.calculateCharactersForOutput(INPUT1);
		     calc.calculateCharactersForOutput(INPUT2);
		     calc.calculateCharactersForOutput(INPUT3);
		     calc.calculateCharactersForOutput(INPUT3);
			 List<String> expected = new ArrayList<String>(); 
			  expected.add(INPUT1);
			  expected.add(INPUT2);
			  expected.add(INPUT3);
			  List<String> actual = calc.getCache().cacheContent();
			  assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
	}
	
	
	@Test 
	void checkCacheInserting_shouldFigureOutputSourceCorrectly_WhenMultipleInputsOccur() {
		      UniqueCharactersCounter calc = new UniqueCharactersCounter();
		      String INPUT0 = "hello word!";
		      String INPUT1 = "doing tests";
		      String INPUT2 = "is it working?";
		      String INPUT3 = "printing uniques correctly?";
		      String INPUT4 = "and what about cash?";
		      calc.calculateCharactersForOutput(INPUT0);
		      calc.calculateCharactersForOutput(INPUT1);
		      calc.calculateCharactersForOutput(INPUT2);
		      calc.calculateCharactersForOutput(INPUT0);
		      calc.calculateCharactersForOutput(INPUT0);
		      calc.calculateCharactersForOutput(INPUT3);
		      calc.calculateCharactersForOutput(INPUT1);
		      calc.calculateCharactersForOutput(INPUT4);
		      calc.calculateCharactersForOutput(INPUT3);
			  List<String> expected = new ArrayList<String>(); 
			  expected.add(INPUT1);
			  expected.add(INPUT4);
			  expected.add(INPUT3);
			  List<String> actual = calc.getCache().cacheContent();
			  assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
	}
	
	@Test
	void test_with_verify() {
		UniqueCharactersCounter mockCacl = mock(UniqueCharactersCounter.class);
		 String INPUT0 = "hello word!";
		 mockCacl.calculateCharactersForOutput(INPUT0);
	}
	
}
