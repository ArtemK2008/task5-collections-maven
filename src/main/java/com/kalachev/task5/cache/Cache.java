package com.kalachev.task5.cache;

import java.util.List;

public interface Cache<K,V>{
	
   V get(K key);
   void put (K ket, V value);
   boolean containsKey(K k);
   List<K> cacheContent();
}