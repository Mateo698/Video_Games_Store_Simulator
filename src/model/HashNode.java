package model;

public class HashNode<K, V> {
	private K key;
	private V value;
	private int hashCode = 0;
	private HashNode<K,V> next;
	
	public HashNode(K key, V value, int code) {
		this.key = key;
		this.value = value;
		hashCode = code;
		next = null;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
	
	public int getCode() {
		return hashCode;
	}
	
	public HashNode<K,V> getNext(){
		return next;
	}
	
	public void setNext(K key, V value, int code) {
		next = new HashNode<K,V>(key,value, code);
	}
	
}
