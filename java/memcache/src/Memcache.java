package com.renm.gitpractice.java.memcache;
public interface Memcache<K, V> {
    public K put(K key, V val);
    public V get(K key);
}
