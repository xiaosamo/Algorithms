package 负载均衡;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan
 * @date 2019/9/17
 * @description
 */
public class Test {
    private static int n = 10;
    public static void main(String[] args) {
        List<Invoker> list = new ArrayList<>();
        list.add(new Invoker("192.168.1.1", 2));
        list.add(new Invoker("192.168.1.2", 3));
        list.add(new Invoker("192.168.1.3", 5));


//        LoadBalance random = new RandomSelect();
//        for (int i = 0; i < n; i++) {
//            System.out.println(random.select(list));
//        }


//        LoadBalance randomLoadBalance = new RandomLoadBalance();
//        for (int i = 0; i < n; i++) {
//            System.out.println(randomLoadBalance.select(list));
//        }

        LoadBalance roundRobinLoadBalance = new RoundRobinLoadBalance();
        for (int i = 0; i < n; i++) {
            System.out.println(roundRobinLoadBalance.select(list));
        }



    }



}
