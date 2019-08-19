package other;


/**
 * @author yuan
 * @date 2019/2/24
 * @description 基于堆的优先队列
 */
public class MaxPQ<Key extends Comparable<Key>> {
    /**
     * 存放数据的数组
     */
    private Key[] pq;
    /**
     * 队列大小
     */
    private int N = 0;

    public MaxPQ(int maxN){
        // pq[1]为最大元素，pq[0]未使用
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    /**
     * 插入元素
     * 将新元素加到数组末尾，增加堆大小并让这个新元素上浮到合适的位置
     * @param key
     */
    public void insert(Key key) {
        // 将元素先放入到数组最后
        pq[++N] = key;
        // 恢复堆的有序性
        swim(N);
    }


    /**
     * 删除最大元素
     * 从数组顶端删去最大的元素并将数组的最后一个元素放到顶端，减小堆的大小并让这个元素下沉到合适的位置
     * @return
     */
    public Key delMax(){
        // 从根节点得到最大元素
        Key max = pq[1];
        // 将其和最后一个节点交换
        exch(1, N--);
        // 设置为null，让系统回收空间
        pq[N + 1] = null;
        // 恢复堆的有序性
        sink(1);
        return max;
    }

    /**
     * 由下至上的堆有序化（上浮）
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k /= 2;
        }

    }

    /**
     * 由上至下的堆有序化（下沉）
     * @param k
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                ++j;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private  boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public static void main(String[] args) {
        MaxPQ<Integer> mq = new MaxPQ<>(10);
        mq.insert(8);
        mq.insert(1);
        mq.insert(2);
        mq.insert(10);


        while (!mq.isEmpty()) {
            System.out.println(mq.delMax());
        }

    }



}
