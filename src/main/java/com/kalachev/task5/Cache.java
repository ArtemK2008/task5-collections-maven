package com.kalachev.task5;

import java.util.Map;

public interface Cache {

	Map<String, String> getCache();

	void setCache(Map<String, String> cache);

	void add(String input, String output);

	String displayCacheContentKeys();

}