package other.javabasice.reflect;

/**
 * @author yuan
 * @date 2019/3/18
 * @description
 */
public class LoadDifference {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取Robot的ClassLoader
//        ClassLoader classLoader = Robot.class.getClassLoader();
        Class<?> clazz = Class.forName("other.javabasice.reflect.Robot");
    }
}
