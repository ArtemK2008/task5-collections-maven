package com.kalachev.task5;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache {
	Map<String, String> cache;
	int capacity;

	public LruCache(int capacity) {
		super();
		this.cache = new LinkedHashMap<>();
		this.capacity = capacity;
	}

	public void add(String input,String output) {
		if (cache.size() == capacity) {
			String firstKey = cache.keySet().iterator().next();
           cache.remove(firstKey);
		}
		cache.put(input, output);
	}
	
	public String displayCacheContentKeys() {
		StringBuilder sb = new StringBuilder();
		for(String s: cache.keySet()) {
			sb.append(s + ",");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
}
