package other;


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/13
 * @description 队列（链表实现）
 */
public class Queue<Item> implements Iterable<Item> {

    /**
     * 指向队列的头节点
     */
    private Node<Item> first;

    /**
     * 指向队列的尾节点
     */
    private Node<Item> last;

    /**
     *  队列大小
     */
    private int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Queue(){
        n = 0;
        first = null;
        last = null;
    }

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    /**
     * 向队列尾部添加元素
     * @param item
     */
    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        // 当队列为空，first和last都指向新的节点
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        ++n;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        return first.item;
    }

    /**
     * 从队列头部删除元素
     * @return
     */
    public Item dequeue(){
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        Item item = first.item;
        first = first.next;
        --n;
        if (isEmpty()) {
            // to avoid loitering
            last = null;
        }
        return item;


    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<>(first);
    }

    private class ListIterator<Item> implements Iterator<Item>{

        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String item = in.next();
            if (!item.equals("-")) {
                queue.enqueue(item);
            } else if (!queue.isEmpty()) {
                System.out.println(queue.dequeue() + " ");
            }
        }
        System.out.println("(" + queue.size() + " left on queue)");
    }
}
