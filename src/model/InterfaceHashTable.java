package model;

public interface InterfaceHashTable<K,V> {
	public void insert(K key, V value) throws Exception;
	public V search(K key);
	public V delete(K key);
}
