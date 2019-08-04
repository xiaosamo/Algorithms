package other;

import java.util.*;

public class 自定义排序2 {
    public static void main(String []args){
        Scanner in =new Scanner(System.in);
        Random random = new Random();

        Integer []a=new Integer[100]; //注意这里是Integer不是int
//        Integer []a={1,2,3,4,5,6,7,8,9,10};
        for (int i = 0; i < a.length; i++) {
            a[i]=random.nextInt(a.length);
        }
        System.out.println(Arrays.toString(a));

//        Arrays.sort(a,Collections.reverseOrder()); //升序
        Arrays.sort(a, new cmp());
        System.out.println(Arrays.toString(a));

        Arrays.sort(a, Collections.reverseOrder());
        System.out.println(Arrays.toString(a));

    }

    static class cmp implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }

}
