package 并发编程;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yuan
 * @date 2020/2/12
 * 用 ReadWriteLock 快速实现一个通用的缓存工具类。
 */
public class Cache<K,V> {
    final Map<K, V> map = new HashMap<>();

    final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    final Lock readLock = readWriteLock.readLock();
    final Lock writeLock = readWriteLock.writeLock();



    public V get(K key){
        readLock.lock();
        try {
            return map.get(key);
        }finally {
            readLock.unlock();
        }
    }

    public V put(K key, V val) {
        writeLock.lock();
        try {
            return map.put(key, val);
        }finally {
            writeLock.unlock();
        }
    }


    public static void main(String[] args) {
        Cache<String, Integer> cache = new Cache<>();

        cache.put("a", 12);
        cache.put("b", 13);

        System.out.println(cache.get("a"));
        System.out.println(cache.get("b"));

    }


}
