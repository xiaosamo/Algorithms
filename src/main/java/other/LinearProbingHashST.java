package other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuan
 * @date 2019/2/28
 * @description 基于线性探测法的散列表
 */
public class LinearProbingHashST<Key , Value> {
    private static final int DEFAULT_CAPACITY = 4;

    /**
     * 符号表中键值对总数
     */
    private int n;
    /**
     * 线性探测表大小
     */
    private int m;
    /**
     * 键
     */
    private Key[] keys;
    /**
     * 值
     */
    private Value[] vals;


    public LinearProbingHashST(){
        this(DEFAULT_CAPACITY);
    }

    public LinearProbingHashST(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[]) new Object[m];
        vals = (Value[]) new Object[m];
    }

    public int size(){
        return n;
    }


    public boolean isEmpty(){
        return size() == 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    private void resize(int capacity) {
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m = temp.m;
    }

    /**
     * 插入
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {
        if (key == null) {
            throw new IllegalArgumentException("first argument to put() is null");
        }

        if (val == null) {
            // 值为null，则删除对应的键
            delete(key);
            return;
        }
        // 如果使用率大于1/2，扩大数组
        if (n >= m / 2) {
            resize(2 * m);
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                // 如果键存在，更新
                vals[i] = val;
                return;
            }
        }
        // 键不存在
        keys[i] = key;
        vals[i] = val;
        ++n;
    }

    /**
     * 删除，需要将被删除键的右侧的所有键重新插入散列表
     * @param key
     */
    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        if (!contains(key)) {
            return;
        }
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }
        // 找到要删除的键
        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % m;
        // 将被删除的键的右侧重新插入
        while (keys[i] != null) {
            Key keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            --n;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }
        // 减去被删除的键
        --n;
        // 如果使用率为1/8，缩小数组
        if (n > 0 && n == m / 8) {
            resize(m / 2);
        }
    }

    /**
     * 获取
     * @param key
     * @return
     */
    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to get() is null");
        }
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to contains() is null");
        }
        return get(key) != null;
    }

    public Iterable<Key> keys(){
        Queue<Key> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                queue.offer(keys[i]);
            }
        }
        return queue;
    }

    public static void main(String[] args) {

        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<>();
        st.put("ccc", 2);
        st.put("bbb", 3);
        st.put("aaa", 1);
        st.put("ddd", 1);


        for (String s : st.keys()) {
            System.out.println(s + " " + st.get(s));
        }
        System.out.print("keys = ");
        st.keys().forEach(s -> System.out.print(s + ","));
        System.out.println();

        System.out.println(st.contains("aaa")); // true
        System.out.println(st.contains("cda")); // false
    }

}
