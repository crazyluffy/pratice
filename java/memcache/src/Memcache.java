public interface Memcache<K, V> {
    public V put(K key, V val);
    public V get(K key);
}
