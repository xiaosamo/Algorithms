package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yuan
 * @date 2020/1/18
 * @description
 * 使用LinkedHashMap实现
 */
public class LRU缓存机制 {
    static class LRUCache extends LinkedHashMap<Integer,Integer>{

        private int capacity;
        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    public static void main(String[] args) {
        LRUCache lru = new LRU缓存机制.LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);

        System.out.println(lru.get(1));

        lru.put(3, 3);
        System.out.println(lru.get(2));


    }
}
