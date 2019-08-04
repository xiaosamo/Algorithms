package other.javabasice;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author yuan
 * @date 2019/3/15
 * @description
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.ext.dirs"));
        String name = "";
        ArrayList<String> list = new ArrayList<>();
        Class<? extends ArrayList> c = list.getClass();
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(name)) {
//                ClassLoader


            }
        }

    }

    private void stackLeakByThread(){
        while (true) {
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                    }
                }
            }.start();
        }
    }


}
