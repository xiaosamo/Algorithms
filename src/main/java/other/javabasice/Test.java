package other.javabasice;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/**
 * @author yuan
 * @date 2019/3/15
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        Class<? extends Test> c = test.getClass();

        //获取类的名称
        System.out.println("类的名称是：" + c.getName());

        /*
         * Method类，方法的对象
         * 一个成员方法就是一个Method对象
         * getMethods()方法获取的是所有的public的函数，包括父类继承而来的
         * getDeclaredMethods()获取的是多有该类自己声明的方法，不问访问权限
         */
        Method[] ms = c.getMethods();//c.getDeclaredMethods();
        for(int i =0; i < ms.length; i++){
//得到方法的返回值类型的类类型
            Class retrunType = ms[i].getReturnType();
            System.out.print(retrunType.getName()+" ");
//得到方法的名称
            System.out.print(ms[i].getName()+"(");
//获取的参数类型--->得到的是参数列表的类型的类类型
            Class[] paraTypes = ms[i].getParameterTypes();
            for(Class class1 : paraTypes){
                System.out.print(class1.getName()+",");
            }
            System.out.println(")");
        }

//        try {
//            Class<?> test  = Class.forName("Test");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            System.err.println("未找到类");
//        }

    }

    public static void hello(){
        System.out.println("hello");

        String str = new String("abc"); // 强引用
//        SoftReference<String> softReference = new SoftReference<>(str); // 软引用
        WeakReference<String> softReference = new WeakReference<>(str); // 弱引用


        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference ref = new PhantomReference(str, queue);

    }
}
