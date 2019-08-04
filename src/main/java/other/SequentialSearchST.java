package other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuan
 * @date 2019/2/25
 * @description 符号表，键值对(Map)，无序链表实现
 */
public class SequentialSearchST<Key,Value> {

    /**
     * 链表首节点
     */
    private Node first;
    /**
     * 大小
     */
    private int n;


    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to get() is null");
        }
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("first argument to put() is null");
        }
        if (value == null) {
            // 防止value为null,如果value为null，删除对应key
            delete(key);
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                // 命中，更新
                x.value = value;
            }
        }
        // 未命中，新建节点
        first = new Node(key, value, first);
        n++;
    }

    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to contains() is null");
        }
        return get(key) != null;
    }

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to contains() is null");
        }
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        if (key.equals(x.key)) {
            --n;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public Iterable<Key> keys(){
        Queue<Key> queue = new LinkedList<>();
        for (Node x = first; x != null; x = x.next) {
            queue.offer(x.key);
        }
        return queue;
    }

    public static void main(String[] args) {
        SequentialSearchST<String, Integer> map = new SequentialSearchST<>();
        map.put("aaa", 1);
        map.put("bbb", 3);
        map.put("ccc", 2);

        System.out.println(map.get("aaa")); // 1
        System.out.println(map.size());  // 3
        System.out.println(map.get("bbb")); // 3
        map.delete("aaa");
        System.out.println(map.get("aaa")); // null

    }

}
