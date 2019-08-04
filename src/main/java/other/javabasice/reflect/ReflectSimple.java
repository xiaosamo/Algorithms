package other.javabasice.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yuan
 * @date 2019/3/17
 * @description 反射例子
 */
public class ReflectSimple {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        // 获取Robot类，需要包名
        Class<?> clazz = Class.forName("other.javabasice.reflect.Robot");
        // 获取类的实例
        Robot robot = (Robot) clazz.getDeclaredConstructor().newInstance();
        // 打印类名
        System.out.println("Class name is " + clazz.getName());
        // 获取声明的方法。可以获取public、private、protect方法..但不能获取继承的方法、所实现的接口的方法
        // String是throwHello的参数
        Method getHello = clazz.getDeclaredMethod("throwHello", String.class);
        // 忽略掉访问修饰符，默认false，如果直接方法private方法会报错
        getHello.setAccessible(true);
        // 第1个参数是对象的实例，第2个是传入的参数
        Object str = getHello.invoke(robot, "Bob");
        System.out.println("getHello result is " + str);

        // 获取name属性
        Field name = clazz.getDeclaredField("name");
        // name是private的
        name.setAccessible(true);
        name.set(robot,"Alice");


        // 调用hello方法
        // getMethod只能获取类的public方法，还能获取继承类public的方法、所实现的接口的方法
        Method sayHello = clazz.getMethod("sayHello", String.class);
        sayHello.invoke(robot, "Welcome");
    }
}
