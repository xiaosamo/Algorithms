package leetcode.面试题;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author yuan
 * @date 2019/3/5
 * @description
 */
public class 常数时间插入_删除和获取随机元素 {


    static class RandomizedSet {

        private List<Integer>[] vals;

        private int n;

        private int m;

        private static final int DEFAULT_CAPACITY = 997;


        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            this(DEFAULT_CAPACITY);
        }

        public RandomizedSet(int m) {
            this.m = m;
            vals = new List[m];
            for (int i = 0; i < m; i++) {
                vals[i] = new ArrayList<>();
            }
        }

        private int hash(int val) {
            return (val >>> 16) % m;
        }

        private void resize(int capacity) {
            RandomizedSet temp = new RandomizedSet(capacity);
            for (int i = 0; i < m; i++) {
                temp.vals[i] = vals[i];
            }
            this.vals = temp.vals;
            this.m = temp.m;
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            boolean contain = get(val) != null;
            vals[hash(val)].add(val);
            if (!contain) {
                ++n;
            }
            if (n >= m * 10) {
                resize(m * 2);
            }
            return contain;
        }

        public Integer get(int val) {
            int i = hash(val);
            for (Integer v : vals[i]) {
                if (v.equals(val)) {
                    return v;
                }
            }
            return null;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            boolean contain = false;
            int i = hash(val);
            for (int k = 0; k < vals[i].size(); k++) {
                if (vals[i].get(k).equals(val)) {
                    contain = true;
                    vals[i].remove(k);
                    --n;
                }
            }
//            if (n <= m * 2) {
//                resize(m / 2);
//            }
            return contain;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            Random random = new Random();
            random.nextInt(n);
            int index = (int) (Math.random() * 100) % n;
            return vals[index].get(vals[index].size() - 1);
        }

    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        System.out.println(set.insert(3)); // false
        System.out.println(set.insert(4)); // false
        System.out.println(set.get(3));
        System.out.println(set.getRandom());

//        System.out.println(set.insert(3)); // true
//        System.out.println(set.remove(3)); // true
//        System.out.println(set.get(3));

//        System.out.println(set.insert(3)); // false
//        System.out.println(set.insert(4)); // false
//        System.out.println(set.insert(5)); // false
//        System.out.println(set.insert(6)); // false



    }

}
