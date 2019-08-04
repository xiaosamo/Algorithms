package other;


/**
 * @author yuan
 * @date 2019/2/27
 * @description 红黑树
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private Node root;

    /**
     * true表示红色
     */
    private static final boolean RED = true;
    /**
     * false表示黑色
     */
    private static final boolean BLACK = false;

    private class Node {
        Key key;
        Value val;
        /**
         * 左右子树
         */
        Node left, right;
        /**
         * 这颗子树中的节点总数
         */
        int n;
        /**
         * 由其父节点指向它的链接的颜色
         */
        boolean color;

        Node(Key key, Value val, int n, boolean color) {
            this.key = key;
            this.val = val;
            this.n = n;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) {
            // 规定空链接为黑色
            return false;
        }
        return x.color == RED;
    }

    public int size(){
        return size(root);
    }

    public boolean isEmpty(){
        return root == null;
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.n;
    }

    /**f
     * 左旋转
     * @param h
     * @return
     */
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = size(h.left) + size(h.right) + 1;
        return x;
    }



    /**
     * 右旋转
     * @param h
     * @return
     */
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = size(h.left) + size(h.right) + 1;
        return x;
    }

    /**
     * 将两个红色子节点的变为黑色，同时将父节点由黑变红
     * @param h 必须有两个子节点
     */
    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    /**
     * 插入
     * @param key
     * @param val
     */
    public void put(Key key,Value val) {
        if (key == null) {
            throw new IllegalArgumentException("first argument to put() is null");
        }
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
        // 根节点总是黑色
        root.color = BLACK;

    }

    private void delete(Key key) {

    }

    private Node put(Node h, Key key, Value val) {
        if (h == null) {
            // 标准的插入操作，与父节点用红链接相连
            return new Node(key, val, 1, RED);
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, val);
        } else if (cmp > 0) {
            h.right = put(h.right, key, val);
        } else {
            h.val = val;
        }

        // 插入的三种情况
        if (isRed(h.right) && !isRed(h.left)) {
            // 1.红链接出现在右边，需要左旋转
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            // 2.左边出现连续两条红链接，需要右旋转
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            // 3.两边都出现红链接，调整颜色
            flipColors(h);
        }
        h.n = size(h.left) + size(h.right) + 1;
        return h;
    }


}
