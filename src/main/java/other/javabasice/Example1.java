package other.javabasice;

/**
 * @author yuan
 * @date 2019/3/3
 * @description
 */
public class Example1 {

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;

        swap(num1, num2);

        // num1、num2未改变
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }


}
