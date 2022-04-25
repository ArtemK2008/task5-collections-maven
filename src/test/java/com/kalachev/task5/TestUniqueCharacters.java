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
	
	@Test
	void printUniques_shouldReturnIlligalArgumentException_whenInpuIsNull() {
		LruCache lru = new LruCache(1);
		  UniqueCharacters uniqueCharacters = new UniqueCharacters();
		  
	     assertThrows(IllegalArgumentException.class, () -> uniqueCharacters.printUniqs(NULL, lru));
	}
	
	@Test
	void printUniques_shouldPrintUniqueCharsAndItsAmount_whenEmptyInput() {
	  LruCache lru = new LruCache(1);
	  UniqueCharacters uniqueCharacters = new UniqueCharacters();
	  
	  String expected = String.format
			  ("");
	  String actual = uniqueCharacters.printUniqs(EMPTY, lru);
	  assertEquals(expected, actual);
}
	
	@Test
	void printUniques_shouldPrintUniqueCharsAndItsAmount_whenInput0() {
	  LruCache lru = new LruCache(1);
	  UniqueCharacters uniqueCharacters = new UniqueCharacters();
	  
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
	  String actual = uniqueCharacters.printUniqs(INPUT0, lru);
	  assertEquals(expected, actual);
}
	@Test
	void printUniques_shouldPrintUniqueCharsAndItsAmount_whenInput1() {
	  LruCache lru = new LruCache(1);
	  UniqueCharacters uniqueCharacters = new UniqueCharacters();
	  
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
	  String actual = uniqueCharacters.printUniqs(INPUT1, lru);
	  assertEquals(expected, actual);
}
	@Test
	void printUniques_shouldPrintUniqueCharsAndItsAmount_whenInput2() {
	  LruCache lru = new LruCache(1);
	  UniqueCharacters uniqueCharacters = new UniqueCharacters();
	  
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
	  String actual = uniqueCharacters.printUniqs(INPUT2, lru);
	  assertEquals(expected, actual);
}
	@Test
	void printUniques_shouldPrintUniqueCharsAndItsAmount_whenInput3() {
	  LruCache lru = new LruCache(1);
	  UniqueCharacters uniqueCharacters = new UniqueCharacters();
	  
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
	  String actual = uniqueCharacters.printUniqs(INPUT3, lru);
	  assertEquals(expected, actual);
}
	@Test
	void printUniques_shouldPrintUniqueCharsAndItsAmount_whenInput4() {
	  LruCache lru = new LruCache(1);
	  UniqueCharacters uniqueCharacters = new UniqueCharacters();
	  
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
	  String actual = uniqueCharacters.printUniqs(INPUT4, lru);
	  assertEquals(expected, actual);
}
	@Test 
	void checkCacheInserting_shouldStoreOneElement_whenOnlyOneStringInApp() {
		LruCache lru = new LruCache(1);
		  UniqueCharacters uniqueCharacters = new UniqueCharacters();
		  
		  uniqueCharacters.printUniqs(INPUT0, lru);
		  String expected = INPUT0;
		  String actual = lru.displayCacheContentKeys(lru);
		  
		  assertEquals(expected, actual);
	}
	
	@Test 
	void checkCacheInserting_shouldStoreMostRecentElement_CacheSizeIsOneAndTwoInputs() {
		LruCache lru = new LruCache(1);
		  UniqueCharacters uniqueCharacters = new UniqueCharacters();
		  
		  uniqueCharacters.printUniqs(INPUT0, lru);
		  uniqueCharacters.printUniqs(INPUT1, lru);
		  String expected = INPUT1;
		  String actual = lru.displayCacheContentKeys(lru);
		  
		  assertEquals(expected, actual);
	}
	
	@Test 
	void checkCacheInserting_shouldStoreMostRecentElement_CacheSizeIsFiveAndFiveInputs() {
		LruCache lru = new LruCache(5);
		  UniqueCharacters uniqueCharacters = new UniqueCharacters();
		  
		  uniqueCharacters.printUniqs(INPUT0, lru);
		  uniqueCharacters.printUniqs(INPUT1, lru);
		  uniqueCharacters.printUniqs(INPUT2, lru);
		  uniqueCharacters.printUniqs(INPUT3, lru);
		  uniqueCharacters.printUniqs(INPUT4, lru);
		  String expected =INPUT0 +"," + INPUT1 + "," + INPUT2 + "," + INPUT3 + "," + INPUT4;
		  String actual = lru.displayCacheContentKeys(lru);
		  
		  assertEquals(expected, actual);
	}
	
	@Test 
	void checkCacheInserting_shouldStoreThreeMostRecentElement_CacheSizeIsThreeAndFiveInputs() {
		LruCache lru = new LruCache(3);
		  UniqueCharacters uniqueCharacters = new UniqueCharacters();
		  
		  uniqueCharacters.printUniqs(INPUT0, lru);
		  uniqueCharacters.printUniqs(INPUT1, lru);
		  uniqueCharacters.printUniqs(INPUT2, lru);
		  uniqueCharacters.printUniqs(INPUT3, lru);
		  uniqueCharacters.printUniqs(INPUT4, lru);
		  String expected =INPUT2 + "," + INPUT3 + "," + INPUT4;
		  String actual = lru.displayCacheContentKeys(lru);
		  
		  assertEquals(expected, actual);
	}
	
	@Test 
	void checkCacheInserting_shouldOneElement_WhenfiveSameInputsWereGiven() {
		LruCache lru = new LruCache(3);
		  UniqueCharacters uniqueCharacters = new UniqueCharacters();
		  
		  uniqueCharacters.printUniqs(INPUT0, lru);
		  uniqueCharacters.printUniqs(INPUT0, lru);
		  uniqueCharacters.printUniqs(INPUT0, lru);
		  uniqueCharacters.printUniqs(INPUT0, lru);
		  uniqueCharacters.printUniqs(INPUT0, lru);
		  String expected =INPUT0;
		  String actual = lru.displayCacheContentKeys(lru);
		  
		  assertEquals(expected, actual);
	}
	
	@Test 
	void checkCacheInserting_shouldFigureOutputSourceCorrectly_WhenSameInputsOccur() {
		LruCache lru = new LruCache(3);
		  UniqueCharacters uniqueCharacters = new UniqueCharacters();
		  
		  uniqueCharacters.printUniqs(INPUT0, lru);
		  uniqueCharacters.printUniqs(INPUT0, lru);
		  uniqueCharacters.printUniqs(INPUT0, lru);
		  uniqueCharacters.printUniqs(INPUT0, lru);
		  uniqueCharacters.printUniqs(INPUT0, lru);
		  String actual = uniqueCharacters.outputSourseHistory();
		  String expected = String.format(
		   INPUT0 +"%n" +
		  "this string was outputed from calculations%n"+
		  INPUT0 +"%n" +
		  "this string was outputed from cache%n"+
		  INPUT0 +"%n" +
		  "this string was outputed from cache%n"+
		  INPUT0 +"%n" +
		  "this string was outputed from cache%n"+
		  INPUT0 +"%n" +
		  "this string was outputed from cache%n"
				  );
		  assertEquals(expected, actual);
	}
	
	@Test 
	void checkCacheInserting_shouldFigureOutputSourceCorrectly_whenDifferentImputOccur() {
		LruCache lru = new LruCache(2);
		  UniqueCharacters uniqueCharacters = new UniqueCharacters();
		  
		  uniqueCharacters.printUniqs(INPUT0, lru);
		  uniqueCharacters.printUniqs(INPUT1, lru);
		  uniqueCharacters.printUniqs(INPUT2, lru);
		  uniqueCharacters.printUniqs(INPUT3, lru);
		  uniqueCharacters.printUniqs(INPUT0, lru);
		  String actual = uniqueCharacters.outputSourseHistory();
		  String expected = String.format(
	      INPUT0 +"%n" +
		  "this string was outputed from calculations%n"+
		  INPUT1 +"%n" +
		  "this string was outputed from calculations%n"+
		  INPUT2 +"%n" +
		  "this string was outputed from calculations%n"+
		  INPUT3 +"%n" +
		  "this string was outputed from calculations%n"+
		  INPUT0 +"%n" +
		  "this string was outputed from calculations%n"
				  );
		  assertEquals(expected, actual);
	}
	
	@Test 
	void checkCacheInserting_shouldFigureOutputSourceCorrectly_whenEmptyStringIsAdded() {
		LruCache lru = new LruCache(2);
		  UniqueCharacters uniqueCharacters = new UniqueCharacters();
		  
		  uniqueCharacters.printUniqs(EMPTY, lru);
		  uniqueCharacters.printUniqs(INPUT0, lru);
		  uniqueCharacters.printUniqs(EMPTY, lru);
		  uniqueCharacters.printUniqs(INPUT1, lru);
		  uniqueCharacters.printUniqs(INPUT2, lru);
		  uniqueCharacters.printUniqs(EMPTY, lru);
		  String actual = uniqueCharacters.outputSourseHistory();
		  String expected = String.format(
		   EMPTY +"%n" +
		  "this string was outputed from calculations%n"+
		  INPUT0 +"%n" +
		  "this string was outputed from calculations%n"+
		  EMPTY +"%n" +
		  "this string was outputed from cache%n"+
		  INPUT1 +"%n" +
		  "this string was outputed from calculations%n"+
		  INPUT2 +"%n" +
		  "this string was outputed from calculations%n" +
		  EMPTY +"%n" +
		  "this string was outputed from calculations%n"
				  );
		  assertEquals(expected, actual);
	}
	
		
}
