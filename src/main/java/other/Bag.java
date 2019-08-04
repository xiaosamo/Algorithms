package other;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author yuan
 * @date 2019/3/13
 * @description 背包
 */
public class Bag<Item> implements Iterable<Item>{

    /**
     * 链表的首节点
     */
    private Node<Item> first;

    private int n;

    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }

    public Bag(){
        n = 0;
        first = null;
    }

    public int  size(){
        return n;
    }

    public boolean isEmpty(){
        return n == 0;
    }


    /**
     * 在链表头部添加节点
     */
    public void add(Item item){
        Node oldfirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldfirst;
        ++n;
    }


    @NotNull
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
}
