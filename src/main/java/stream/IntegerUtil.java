package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuan
 * @date 2020/3/28
 */
public class IntegerUtil {

    public static List<String> intToStringList(List<Integer> list) {
        return list.stream().map(String::valueOf).collect(Collectors.toList());
    }

    /**
     * 集合reduce,将集合中每个元素聚合成一条数据
     * 第一个参数是上次函数执行的返回值（也称为中间结果）
     * 第二个参数是stream中的元素，这个函数把这两个值相加，
     * @param list
     * @return
     */
    public static int sum(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
    }

    public static String listToString(List<Integer> list) {
        return list.stream().map(String::valueOf).reduce((s1, s2) -> s1 + "," + s2).get();
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(sum(list)); // 55
        System.out.println(listToString(list));
    }
}
