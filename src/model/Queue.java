package model;

public class Queue<T> {
	private Node<T> first;
	
	public Queue() {
		first = null;
	}
	
	public int getSize() {
		int size = 0;
		if(first == null) {
			return size;
		}else {
			return first.size();
		}
	}
	
	public void add(T object) {
		if(first == null) {
			first = new Node<T>(object);
		}else {
			first.add(object);;
		}
	}
	
	public T poll() {
		if(first == null) {
			return null;
		}else {
			T object = first.getObject();
			first = first.getNext();
			return object;
		}
	}
	
	public T peek() {
		if(first == null) {
			return null;
		}else {
			return first.getObject();
		}
	}
	
}
