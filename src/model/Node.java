package model;

public class Node<T> {
	private T object;
	private Node<T> next;
	
	public Node(T object) {
		this.object = object;
		next = null;
	}
	
	public T getObject() {
		return object;
	}
	
	public Node<T> getNext() {
		return next;
	}
	
	public void setNext(Node<T> n) {
		next = n;
	}
	
	public void add(T object) {
		if(next == null) {
			next = new Node<T>(object);
		}else {
			next.add(object);
		}
	}
	
	public int size() {
		int size = 1;
		if(next == null) {
			return  size;
		}else {
			return next.size(size);
		}
	}
	
	private int size(int size) {
		size++;
		if(next == null) {
			return size;
		}else {
			return next.size(size);
		}
	}
}
