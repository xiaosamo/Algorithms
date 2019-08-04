package other;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * @author yuan
 * @date 2019/2/25
 * @description 基于有序数组的有序符号表
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {


    private Key[] keys;
    private Value[] vals;

    /**
     * 大小
     */
    private int n;

    /**
     * 默认大小
     */
    private static final int DEFAULT_CAPACITY = 2;

    public BinarySearchST() {
        this(DEFAULT_CAPACITY);
    }


    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size(){
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to get() is null");
        }
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            return vals[i];
        }
        return null;
    }

    /**
     * 基于有序数组的二分查找
     * @param key
     * @return 返回小于键的数量
     */
    public int rank(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to rank() is null");
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                r = mid - 1;
            } else if (cmp > 0) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l;
    }

    public void put(Key key, Value val) {
        if (key == null) {
            throw new IllegalArgumentException("first argument to put() is null");
        }
        if (val == null) {
            delete(key);
            return;
        }
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            // 如果键存在，更新值
            vals[i] = val;
            return;
        }
        // 如果容量满，扩容
        if (n == keys.length) {
            resize(2 * keys.length);
        }
        // 移动数组，腾出位置给新的键值对
        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        ++n;
    }

    /**
     * 调整大小
     * @param capacity
     */
    private void resize(int capacity) {
        assert capacity >= n;
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        keys = tempk;
        vals = tempv;
    }

    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to contains() is null");
        }
        return get(key) != null;
    }

    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        if (isEmpty()) {
            return;
        }
        int i = rank(key);
        // 如果键不存在，返回
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }
        // 将数组往前移动
        for (int j = i; j < n - 1; j++) {
            keys[j] = keys[j + 1];
            vals[j] = vals[j + 1];
        }
        // 赋值为null，让系统回收空间
        keys[n] = null;
        vals[n] = null;
        --n;

        // 如果已用空间只占总容量的1/4
        if (n > 0 && n == keys.length / 4) {
            // 缩小容量空间
            resize(keys.length / 2);
        }
    }

    /**
     * 获取最小键的值
     * @return
     */
    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException("called min() with empty symbol table");
        }
        return keys[0];
    }

    /**
     * 获取最大键的值
     * @return
     */
    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException("called max() with empty symbol table");
        }
        return keys[n-1];
    }

    /**
     * 获取第k个键的值
     * @param k
     * @return
     */
    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("called select() with invalid argument: " + k);
        }
        return keys[k];
    }


    /**
     * 获取所有的keys
     * @return
     */
    public Iterable<Key> keys(){
        Queue<Key> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(keys[i]);
        }
        return queue;
    }


    public static void main(String[] args) {
        BinarySearchST<String, Integer> map = new BinarySearchST<>();
        map.put("A", 3);
        map.put("Z", 5);
        map.put("T", 8);
        map.put("S", 4);
        map.put("E", 1);

        for (String key : map.keys()) {
            System.out.println("key=" + key + ",value=" + map.get(key) + ",size=" + map.size());
            map.delete(key);
        }

    }
}
