package com.kalachev.task5;

public class Node<T,U> {
   T key;
   U value;
   Node<T,U> next;
   Node<T,U> prev;
   
   
   public Node(T key, U value, Node<T, U> next, Node<T, U> prev) {
		super();
		this.key = key;
		this.value = value;
		this.next = next;
		this.prev = prev;
	}
   
}
