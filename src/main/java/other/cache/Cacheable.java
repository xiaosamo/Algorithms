package other.cache;

/**
 * @author yuan
 * @date 2020/3/18
 */
public interface Cacheable<K,V> {
    V get(K key);

    void set(K key, V val, long expire);

    void delete(K key);

    boolean exist(K key);

}
