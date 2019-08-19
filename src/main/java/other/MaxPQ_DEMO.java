package other;

/**
 * @author yuanshijia
 * @date 2019-08-19
 * @description
 */
public class MaxPQ_DEMO<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    public MaxPQ_DEMO(int maxN) {
        // pq[1]为最大元素，pq[0]未使用
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key key) {
        pq[++N] = key;
        swim(N);

    }

    /**
     * 从数组顶端删除最大的元素，并将数组的最后一个元素放到顶端，并让这个元素下沉到合适的位置。
     * @return
     */
    public Key delMax() {
        Key max = pq[1];
        swap(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    /**
     * 上浮
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
            k /= 2;
        }
    }

    /**
     * 下沉
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
            swap(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void swap(int i, int j) {
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
