package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yuan
 * @date 2020/4/6
 */
public class ClassA {


    public void callClassB() {
        try {
            Class<?> clazz = Class.forName("test.ClassB");
            Method method = clazz.getMethod("print");
            Object o = clazz.getDeclaredConstructor().newInstance();
            method.invoke(o);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ClassA classA = new ClassA();
        classA.callClassB();
    }
}
