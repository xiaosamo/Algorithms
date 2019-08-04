package other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuan
 * @date 2019/2/28
 * @description 基于拉链法的d
 */
public class SeparateChainingHashST<Key, Value> {

    /**
     * 键值对总数
     */
    private int n;
    /**
     * 散列表大小
     */
    private int m;

    /**
     * 存放链表对象的数组
     */
    private SequentialSearchST<Key, Value>[] st;

    private static final int DEFAULT_CAPACITY = 4;


    public SeparateChainingHashST(){
        this(DEFAULT_CAPACITY);
    }

    public SeparateChainingHashST(int m) {
        this.m = m;
        st = new SequentialSearchST[m];
        for (int i = 0; i < m; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return size() == 0;
    }


    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to get() is null");
        }
        return st[hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("first argument to put() is null");
        }
        if (value == null) {
            delete(key);
            return;
        }
        // 如果 n / m (链表的平均长度) >= 10
        if (n >= 10 * m) {
            resize(2 * m);
        }

        int i = hash(key);
        if (!contains(key)) {
            ++n;
        }
        st[i].put(key, value);
    }

    private boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to contains() is null");
        }
        return get(key) != null;
    }

    private void resize(int chains) {
        SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m = temp.m;
        this.n = temp.n;
        this.st = temp.st;
    }

    private void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        int i = hash(key);
        if (contains(key)) {
            --n;
        }
        st[i].delete(key);

        // 如果 链表平均长度(n / m) <= 2
        if (m > DEFAULT_CAPACITY && n <= 2 * m) {
            resize(m / 2);
        }
    }

    public Iterable<Key> keys(){
        Queue<Key> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                queue.offer(key);
            }
        }
        return queue;
    }

    public static void main(String[] args) {
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<>();

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
