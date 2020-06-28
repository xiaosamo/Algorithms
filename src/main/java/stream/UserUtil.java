package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuan
 * @date 2020/3/28
 */
public class UserUtil {
    private static List<User> list = new ArrayList<>();

    private static int maxAge(List<User> list) {
        return list.stream().mapToInt(User::getAge).max().getAsInt();
    }

    private static int sumAge(List<User> list) {
        return list.stream().mapToInt(User::getAge).sum();
    }


    private static double average(List<User> list) {
        return list.stream().mapToInt(User::getAge).average().getAsDouble();
    }


    private static List<User> filterAgeGh18(List<User> list) {
        return list.stream().filter(u -> u.getAge() > 18).collect(Collectors.toList());
    }

    private static boolean hasId(int id) {
        return list.stream().anyMatch(u -> u.getId() == id);
    }

    public static void main(String[] args) {
        list.add(new User(1,"x", 22));
        list.add(new User(2,"y", 16));
        list.add(new User(3,"z", 33));

        System.out.println(maxAge(list));
        System.out.println(sumAge(list));
        System.out.println(average(list));
        System.out.println(filterAgeGh18(list));
        System.out.println(hasId(2));

    }

}
