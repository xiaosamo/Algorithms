package other;


import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * @author yuan
 * @date 2019/2/26
 * @description 二叉查找树
 */
public class BST<Key extends Comparable, Value> {

    private Node root;

    private class Node{
        private Key key;
        private Value val;
        private Node left, right;
        /**
         * 以该节点为根的子树中的节点总数
         */
        private int n;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            this.n = n;
        }
    }

    public int size(){
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.n;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (key == null) {
            throw new IllegalArgumentException("calls get() with a null key");
        }
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }

    public void put(Key key, Value val) {
        if (key == null) {
            throw new IllegalArgumentException("calls put() with a null key");
        }
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) {
            // 如果key不存在，新建节点
            return new Node(key, val, 1);
        }
        int cmd = key.compareTo(x.key);
        if (cmd < 0) {
            // 如果被查找的键小于根节点，在左子树继续插入该键
            x.left = put(x.left, key, val);
        } else if (cmd > 0) {
            // 如果被查找的键大于于根节点，在左子树继续插入该键
            x.right = put(x.right, key, val);
        } else {
            // 如果key存在，则更新
            x.val = val;
        }
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    public boolean isEmpty(){
        return size() == 0;
    }


    public Key min(){
        if (isEmpty()) {
            throw new NoSuchElementException("calls min() with empty symbol table");
        }
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

    public Key max(){
        if (isEmpty()) {
            throw new NoSuchElementException("calls max() with empty symbol table");
        }
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        }
        return max(x.right);
    }

    public void deleteMin(){
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table underflow");
        }
        root = deleteMin(root);

    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax(){
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table underflow");
        }
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    private void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            // 找到被删除的节点，如果只有一个子节点，或者没有子节点的情况
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            // 有两个子节点，找后继节点min(r.right)
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Iterable<Key> keys(){
        return keys(min(), max());
    }

    /**
     * 查找在给定范围的key
     * @param lo
     * @param hi
     * @return
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new LinkedList<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    /**
     * 使用中序遍历
     * @param x
     * @param queue
     * @param lo
     * @param hi
     */
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) {
            return;
        }
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) {
            keys(x.left, queue, lo, hi);
        }
        if (cmplo <= 0 && cmphi >= 0) {
            // 如果在指定范围内，加入队列
            queue.offer(x.key);
        }
        if (cmphi > 0) {
            keys(x.right, queue, lo, hi);
        }
    }

    public static void main(String[] args) {
        BST<String, Integer> st = new BST<>();

        st.put("A", 3);
        st.put("Z", 5);
        st.put("T", 8);
        st.put("S", 4);
        st.put("E", 1);

        System.out.println();

        for (String s : st.keys()) {
            System.out.println(s + " " + st.get(s));

        }
        System.out.println(st.size());
        System.out.println("max=" + st.max() + ",min=" + st.min());
    }
}
