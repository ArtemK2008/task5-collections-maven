package com.kalachev.task5.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LruCache<K,V> implements Cache<K, V> {
private HashMap<K,Node<K,V>> cache;
private Node<K, V> leastRecentlyUsed;
private Node<K, V> mostRecentlyUsed;
private int maxSize;
private int currentSize;


static final String NEWLINE = System.lineSeparator();

public LruCache(int maxSize) {
	super();
	this.maxSize = maxSize;
	this.currentSize = 0;
	this.leastRecentlyUsed = new Node<K,V>(null,null,null,null);
	this.mostRecentlyUsed = leastRecentlyUsed;
	this.cache = new HashMap<K, Node<K,V>>();
}

public boolean containsKey(K k) {
	return cache.containsKey(k);
}

public V get(K key) {
	Node<K, V> tempNode = cache.get(key);
	if (tempNode == null) {
		return null;
	}
	else if (tempNode.key == mostRecentlyUsed.key) {
		return mostRecentlyUsed.value;
	}
	Node<K, V> nextNode = tempNode.next;
	
	if(tempNode.key == leastRecentlyUsed.key) {
		nextNode.prev = null;
		leastRecentlyUsed = nextNode;
	}
	else if (tempNode.key != mostRecentlyUsed.key) {
		Node<K, V> prevNode = tempNode.prev;
		prevNode.next = tempNode.next;
		nextNode.prev = tempNode.prev;
	}
	
	tempNode.prev = mostRecentlyUsed;
	mostRecentlyUsed.next = tempNode;
	mostRecentlyUsed = tempNode;
	mostRecentlyUsed.next = null;
	return tempNode.value;	
}

public void put (K key,V value) {
	if(cache.containsKey(key)) {
		return;
	}
	Node<K,V> myNode = new Node<K,V> (key,value,mostRecentlyUsed,null);
	mostRecentlyUsed.next = myNode;
	cache.put(key, myNode);
	mostRecentlyUsed = myNode;
	
	if(currentSize == maxSize) {
		cache.remove(leastRecentlyUsed.key);
		leastRecentlyUsed = leastRecentlyUsed.next;
		leastRecentlyUsed.prev = null;
	}
	
	else if (currentSize < maxSize) {
		if (currentSize == 0) {
		  leastRecentlyUsed = myNode;
		}
		currentSize++;
	}
}

public List<K> cacheContent() {
	List<K> content = new ArrayList<>();
	for(K k : cache.keySet()) {
		content.add(k);
	}
	return content;
}

}