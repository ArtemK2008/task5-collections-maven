package com.kalachev.task5;

import java.util.HashMap;
import java.util.Map;

public class NewLru<K, V> implements Cache<K, V> {
	static final String NEWLINE = System.lineSeparator();
	private int capacity;
	private Node<K, V> head, tail;
	private Map<K, Node<K, V>> cache;
	private static final int DEFAULT_CAPACITY = 3;

	public NewLru(int capacity) {
		this.capacity = capacity;
		this.cache = new HashMap<K, Node<K, V>>();
	}

	public NewLru() {
		this(DEFAULT_CAPACITY);
	}

	@Override
	public V get(K key) {
		V result = null;
		Node<K, V> node = this.cache.get(key);
		if (node != null) {
			result = node.value;
			remove(node);
			addAsHead(node);
		}
		return result;
	}

	@Override
	public void put(K key, V value) {
		Node<K, V> node = this.cache.get(key);
		if (node == null) {
			Node<K, V> temp = new Node<K, V>(key, value);
			if (this.cache.size() < this.capacity) {
				addAsHead(temp);
			} else {
				this.cache.remove(this.tail.key);
				remove(this.tail);
				addAsHead(temp);
			}
			this.cache.put(key, temp);
		} else {
			node.value = value;
			remove(node);
			addAsHead(node);
		}
	}

	@Override
	public boolean containsKey(K k) {
		return cache.containsKey(k);
	}

	@Override
	public String displayCacheContents() {
		StringBuilder sb = new StringBuilder();
		for (K k : cache.keySet()) {
			sb.append(k);
			sb.append(NEWLINE);
		}
		int last = sb.lastIndexOf(NEWLINE);
		if (last >= 0) {
			sb.delete(last, sb.length());
		}
		return sb.toString();
	}

	private void addAsHead(Node<K, V> node) {
		if (this.head == null) {
			this.head = node;
			this.tail = node;
		} else {
			this.head.prev = node;
			node.next = this.head;
			this.head = node;
		}
	}

	public void remove(K key) {
		Node<K, V> node = this.cache.get(key);
		if (node != null) {
			this.remove(node);
		}
	}

	private void remove(Node<K, V> node) {
		if (node.prev == null) {
			this.head = node.next;
		} else {
			node.prev.next = node.next;
		}
		if (node.next == null) {
			this.tail = node.prev;
		} else {
			node.next.prev = node.prev;
		}
	}
}
