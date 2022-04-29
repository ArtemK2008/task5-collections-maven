package com.kalachev.task5;


public interface Cache<K,V>{
	
   V get(K key);
   void put (K ket, V value);

}