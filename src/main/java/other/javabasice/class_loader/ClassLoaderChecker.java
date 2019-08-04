package other.javabasice.class_loader;

import java.lang.reflect.InvocationTargetException;

/**
 * @author yuan
 * @date 2019/3/18
 * @description
 */
public class ClassLoaderChecker {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        MyClassLoader myClassLoader = new MyClassLoader("D:\\java\\刷题\\src\\other\\javabasice\\class_loader\\", "myClassLoader");
        Class<?> clazz = myClassLoader.findClass("Wali");
        System.out.println(clazz.getClassLoader());
         // 生成实例
        clazz.getDeclaredConstructor().newInstance();

        clazz = Class.forName("other.javabasice.class_loader.Wali");
        System.out.println(clazz.getName());
        System.out.println(clazz.getClassLoader());
        System.out.println(clazz.getClassLoader().getParent());
        System.out.println(clazz.getClassLoader().getParent().getParent()); // null 因为Bootstrap Loader是c/c++的
//        System.out.println(clazz.getClassLoader().getParent().getParent().getParent());

    }
}
