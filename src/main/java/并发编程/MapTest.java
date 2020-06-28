package 并发编程;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuan
 * @date 2020/2/13
 */
public class MapTest {
    public static void main(String[] args) {


        Map<String, Integer> map = new HashMap<>();


        String key = "aaa";


        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }

        System.out.println(map.get(key));

        // 等价于上面
        // 如果key存在，则执行lambda表达式，表达式入参为oldVal和newVal(neVal即merge()的第二个参数)。表达式返回最终put的val。
        // 如果key不存在，则直接put newVal。
        map.merge(key, 1, (oldVal, newVal) -> oldVal + newVal);


        // 还可以传入该方法的引用
        map.merge(key, 1, Integer::sum);


        System.out.println(map.get(key));



    }
}
