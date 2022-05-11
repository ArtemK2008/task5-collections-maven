package com.kalachev.task5.cache;

public class Node<T,U> {
   T key;
   U value;
   Node<T,U> prev;
   Node<T,U> next;
   
   
   public Node(T key, U value, Node<T, U> prev, Node<T, U> next) {
		super();
		this.key = key;
		this.value = value;
		this.prev = prev;
		this.next = next;
	}
   
   Node(T key, U value) {
       this.key = key;
       this.value = value;
   }

   
}