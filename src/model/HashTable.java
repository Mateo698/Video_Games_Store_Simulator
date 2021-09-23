package model;

import java.util.ArrayList;
import java.util.Objects;

public class HashTable<K,V> implements InterfaceHashTable<K, V>{
	private ArrayList<HashNode<K,V>> nodes;
	private int bucket;
	private int size;
	
	public HashTable() {
		nodes = new ArrayList<>();
		size = 0;
		bucket = 10;
		for (int i = 0; i < nodes.size(); i++) {
			nodes.add(null);
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public int hashCode(K key) {
		int code = Objects.hashCode(key);
		return code;
	}
	
	public int getIndex(K key) {
		int hashCode = hashCode(key);
		int index = hashCode % bucket;
        index = index < 0 ? index*-1 : index;
        return index;
	}
	
	@Override
	public void insert(K key, V value) throws Exception {
		int hashCode = hashCode(key);
		int index = getIndex(key);
		HashNode<K, V> head = nodes.get(index);
		HashNode<K,V> newNode = new HashNode<K, V>(key, value, hashCode);
		while(head != null) {
			if(head.getKey().equals(newNode.getKey()) && head.getCode() == hashCode) {
				return;
			}
			head = head.getNext();
		}
		
		
	}

	@Override
	public V search(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(K key) {
		// TODO Auto-generated method stub
		
	}
	

}
