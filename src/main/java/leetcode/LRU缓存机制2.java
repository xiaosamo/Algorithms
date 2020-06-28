package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yuan
 * @date 2020/1/18
 * @description
 * 使用LinkedHashMap实现
 */
public class LRU缓存机制2 {
    static class LRUCache {

        class Node{
            int key;
            int value;
            Node prev;
            Node next;
        }

        // 添加到head后面
        private void addNode(Node node) {
            node.next = head.next;
            node.prev= head;

            head.next.prev = node;
            head.next = node;
        }


        // 删除节点
        private void removeNode(Node node) {
            Node prev = node.prev;
            Node next = node.next;

            prev.next = next;
            next.prev = prev;
        }

        // 移动到头节点
        private void moveToHead(Node node){
            removeNode(node);
            addNode(node);
        }

        // 删除尾节点
        private Node popTail(){
            Node res = tail.prev;
            removeNode(res);
            return res;
        }

        private HashMap<Integer, Node> map = new HashMap<>();

        private int size;
        private int capacity;

        // 头尾节点，可以避免判断null
        private Node head,tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;

            head = new Node();
            tail = new Node();

            head.next = tail;
            tail.prev = head;
        }

        public int get(int key){
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            // 如果存在节点，删除后重新插入
            moveToHead(node);
            return node.value;
        }

        public void put(int key,int value){

            Node node = map.get(key);
            if (node == null) {
                Node newNode = new Node();

                newNode.key = key;
                newNode.value = value;

                addNode(newNode);
                ++size;
                if (size > capacity) {
                    Node t = popTail();
                    map.remove(t.key);
                    --size;
                }

                map.put(key, newNode);
            } else {
                // 如果存在，更新
                node.value = value;
                moveToHead(node);
            }
        }

    }

    public static void main(String[] args) {
        LRUCache lru = new LRU缓存机制2.LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);

        System.out.println(lru.get(1));

        lru.put(3, 3);
        System.out.println(lru.get(2));


    }
}
