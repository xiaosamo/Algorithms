package 基础练习;


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/12
 * @description 下压栈（链表实现）
 */
public class Stack<Item> implements Iterable<Item> {

    /**
     * 栈顶
     */
    private Node<Item> first;

    /**
     * 元素数量
     */
    private int n;


    private static class Node<Item> {
        private Item item;
        private Node next;
    }

    public Stack(){
        first = null;
        n = 0;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    /**
     * Return the number of items in this stack
     * @return
     */
    public int size(){
        return n;
    }

    /**
     * Adds the item to this stack first
     * @param item
     */
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        ++n;
    }

    /**
     * Removed and returns the item most recently added to this stack
     * @return
     */
    public Item pop(){
        Item item = first.item;
        first = first.next;
        --n;
        return item;
    }

    /**
     * Returns (but does not removed) the item most recently to this stack
     * @return
     */
    public Item peek(){
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        return first.item;
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

    private class ListIterator<Item> implements  Iterator<Item> {

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
        Stack<String> stack = new Stack<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String item = in.next();
            if (!item.equals("-")) {
                stack.push(item);
            } else if (!stack.isEmpty()) {
                System.out.println(stack.pop() + " ");
            }
        }
        System.out.println("(" + stack.size() + " left on stack)");
    }

}
