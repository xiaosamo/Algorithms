package other.javabasice;

/**
 * @author yuan
 * @date 2019/3/15
 * @description
 */

import java.lang.reflect.Method;

public class PrivateMethodTestHelper {
    public static Object invoke(String clazzName,String methodName,Object...params){
        try {
            // 根据类名返回类的对象
            Class<?> clazz=Class.forName(clazzName);
            // 获得该类中与参数类型匹配的构造方法
            Object obj=clazz.getDeclaredConstructor().newInstance();
            // 获得该类所有方法
            Method[] methods = clazz.getDeclaredMethods();
            Method callMethod=null;
            for(Method method:methods){
                System.out.println(method.getName());
                if(method.getName().equals(methodName)){
                    callMethod=method;
                    break;
                }
            }
            callMethod.setAccessible(true);
            return (Object) callMethod.invoke(obj,params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        int value = (Integer) PrivateMethodTestHelper.invoke("other.javabasice.AddNumber", "addNumber", 1, 2);
        System.out.println(value);
    }

}