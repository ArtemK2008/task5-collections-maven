package com.kalachev.task5;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestUniqueCharacters {

	static final String INPUT0 = "hello word!";
	static final String INPUT1 = "doing tests";
	static final String INPUT2 = "is it working?";
	static final String INPUT3 = "printing uniques correctly?";
	static final String INPUT4 = "and what about cash?";
	static final String EMPTY= "";
	static final String NULL= null;
	static final String NEWLINE = System.lineSeparator();
	
	
	
	
	
	
	@Test
	void printUniques_shouldReturnIlligalArgumentException_whenInpuIsNull() {
    ConsloleResultPrinter resultPrinter = new ConsloleResultPrinter();		  
	     assertThrows(IllegalArgumentException.class, () -> resultPrinter.printUniquesCharsAmounts(NULL));
	}
	
	@Test
	void printUniques_shouldPrintUniqueCharsAndItsAmount_whenEmptyInput() {
		ConsloleResultPrinter resultPrinter = new ConsloleResultPrinter();		  
	     assertThrows(IllegalArgumentException.class, () -> resultPrinter.printUniquesCharsAmounts(EMPTY));
}
	
	@Test
	void printUniques_shouldPrintUniqueCharsAndItsAmount_whenInput0() {
		ConsloleResultPrinter resultPrinter = new ConsloleResultPrinter();
		
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
		ConsloleResultPrinter resultPrinter = new ConsloleResultPrinter();
		  
		  resultPrinter.printUniquesCharsAmounts(INPUT0);
		  String expected = INPUT0;
		  String actual = resultPrinter.getCache().displayCacheContents();
		  assertEquals(expected, actual);
	}
	@Test 
	void checkCacheInserting_shouldStoreMostRecentElement_CacheSizeIsOneAndTwoInputs() {
		ConsloleResultPrinter resultPrinter = new ConsloleResultPrinter();
		 resultPrinter.printUniquesCharsAmounts(INPUT0);
		 resultPrinter.printUniquesCharsAmounts(INPUT1);
		  String expected = INPUT0 + NEWLINE+ INPUT1;
		  String actual = resultPrinter.getCache().displayCacheContents();
		  assertEquals(expected, actual);
	}
	
	@Test 
	void checkCacheInserting_shouldStoreMostRecentElement_CacheSizeIsThreeAndFiveInputs() {
		ConsloleResultPrinter resultPrinter = new ConsloleResultPrinter();
		 resultPrinter.printUniquesCharsAmounts(INPUT0);
		 resultPrinter.printUniquesCharsAmounts(INPUT1);
		 resultPrinter.printUniquesCharsAmounts(INPUT2);
		 resultPrinter.printUniquesCharsAmounts(INPUT3);
		 resultPrinter.printUniquesCharsAmounts(INPUT4);
		String expected =INPUT2 + NEWLINE + INPUT3 + NEWLINE + INPUT4;
		 String actual = resultPrinter.getCache().displayCacheContents();
		  assertEquals(expected, actual);
	}
	
	@Test 
	void checkCacheInserting_shouldStoreThreeMostRecentElement_CacheSizeIsThreeAndFiveInputs() {
		ConsloleResultPrinter resultPrinter = new ConsloleResultPrinter();
		 resultPrinter.printUniquesCharsAmounts(INPUT0);
		 resultPrinter.printUniquesCharsAmounts(INPUT1);
		 resultPrinter.printUniquesCharsAmounts(INPUT2);
		 resultPrinter.printUniquesCharsAmounts(INPUT3);
		 resultPrinter.printUniquesCharsAmounts(INPUT4);
		String expected =INPUT2 +NEWLINE + INPUT3 + NEWLINE + INPUT4;
		 String actual = resultPrinter.getCache().displayCacheContents();
		  assertEquals(expected, actual);
	}
	
	@Test 
	void checkCacheInserting_shouldOneElement_WhenfiveSameInputsWereGiven() {
		ConsloleResultPrinter resultPrinter = new ConsloleResultPrinter();
		 resultPrinter.printUniquesCharsAmounts(INPUT0);
		 resultPrinter.printUniquesCharsAmounts(INPUT0);
		 resultPrinter.printUniquesCharsAmounts(INPUT0);
		 resultPrinter.printUniquesCharsAmounts(INPUT0);
		 resultPrinter.printUniquesCharsAmounts(INPUT0);
		String expected =INPUT0;
		 String actual = resultPrinter.getCache().displayCacheContents();
		  assertEquals(expected, actual);
	}
	
	@Test 
	void checkCacheInserting_shouldFigureOutputSourceCorrectly_WhenSameInputsOccur() {
		  ConsloleResultPrinter resultPrinter = new ConsloleResultPrinter();
			 resultPrinter.printUniquesCharsAmounts(INPUT0);
			 resultPrinter.printUniquesCharsAmounts(INPUT1);
			 resultPrinter.printUniquesCharsAmounts(INPUT2);
			 resultPrinter.printUniquesCharsAmounts(INPUT3);
			 resultPrinter.printUniquesCharsAmounts(INPUT3);
			String expected =INPUT1 + NEWLINE + INPUT2 + NEWLINE + INPUT3;
			 String actual = resultPrinter.getCache().displayCacheContents();
			  assertEquals(expected, actual);
	}
	
	@Test 
	void checkCacheInserting_shouldFigureOutputSourceCorrectly_WhenMultipleInputsOccur() {
		  ConsloleResultPrinter resultPrinter = new ConsloleResultPrinter();
			 resultPrinter.printUniquesCharsAmounts(INPUT0);
			 resultPrinter.printUniquesCharsAmounts(INPUT1);
			 resultPrinter.printUniquesCharsAmounts(INPUT2);
			 resultPrinter.printUniquesCharsAmounts(INPUT0);
			 resultPrinter.printUniquesCharsAmounts(INPUT0);
			 resultPrinter.printUniquesCharsAmounts(INPUT3);
			 resultPrinter.printUniquesCharsAmounts(INPUT1);
			 resultPrinter.printUniquesCharsAmounts(INPUT4); 
			 resultPrinter.printUniquesCharsAmounts(INPUT3);
			String expected =INPUT1 + NEWLINE + INPUT3 + NEWLINE + INPUT4;
			 String actual = resultPrinter.getCache().displayCacheContents();
			  assertEquals(expected, actual);
	}
	
}
