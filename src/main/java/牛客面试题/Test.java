package 牛客面试题;

import poj.Main;

/**
 * @author yuan
 * @date 2019/4/12
 * @description
 */
public class Test {
    static {
        System.out.println("B");
    }
    {
        System.out.println("here");
    }
    private int test(){

        return 1;
    }

    private void test(String a) {
    }

    public static void main(String[] args)
    {
        System.out.println("A");
        char myChar = 'g';
        String myStr = Character.toString(myChar);
        System.out.println("String is: "+myStr);
        myStr = String.valueOf(myChar);
        System.out.println("String is: "+myStr);
    }
}
