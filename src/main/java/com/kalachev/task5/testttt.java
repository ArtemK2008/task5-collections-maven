package com.kalachev.task5;

public class testttt {

	static String a1 = "1";
	static String a2 = "2";
	static String a3 = "3";
	static String a4 = "4";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ConsloleResultPrinter resultPrinter = new ConsloleResultPrinter();
		 * resultPrinter.printUniquesCharsAmounts(a1);
		 * System.out.println(resultPrinter.getCache().displayCacheContents());
		 * System.out.println(); resultPrinter.printUniquesCharsAmounts(a2);
		 * System.out.println(resultPrinter.getCache().displayCacheContents());
		 * System.out.println(); resultPrinter.printUniquesCharsAmounts(a3);
		 * System.out.println(resultPrinter.getCache().displayCacheContents());
		 * System.out.println(); resultPrinter.printUniquesCharsAmounts(a4);
		 * System.out.println(resultPrinter.getCache().displayCacheContents());
		 * System.out.println(); resultPrinter.printUniquesCharsAmounts(a3);
		 * System.out.println(resultPrinter.getCache().displayCacheContents());
		 * System.out.println();
		 */
		
		LruCache<Integer,Integer> cache = new LruCache<>(3);
	//	NewLru<Integer,Integer> cache = new NewLru<>(3);
		cache.put(1,1);
		cache.put(2,2);
		cache.put(3,3);
		cache.get(2);
		System.out.println(cache.displayCacheContents());
		
	}

}
