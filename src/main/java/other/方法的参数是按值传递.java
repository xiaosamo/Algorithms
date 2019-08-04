package other;

/**
 * 如果参数类型是原始类型，那么传过来的就是这个参数的一个副本，也就是这个原始参数的值，这个跟之前所谈的传值是一样的。如果在函数中改变了副本的值不会改变原始的值.
 * 　　如果参数类型是引用类型，那么传过来的就是这个引用参数的副本，这个副本存放的是参数的地址。如果在函数中没有改变这个副本的地址，而是改变了地址中的 值，那么在函数内的改变会影响到传入的参数。如果在函数中改变了副本的地址，如new一个，那么副本就指向了一个新的地址，此时传入的参数还是指向原来的 地址，所以不会改变参数的值。
 */
public class 方法的参数是按值传递 {
    private static void swap(int a, int b) {
        //基本类型参数传递：不改变值
        int t=a;
        a=b;
        b=t;
        System.out.println("swap中a=" + a + "，b=" + b);
    }

    private static void add(int a) {
        //基本类型参数传递：不改变值
        a = 100;
    }

    public static void reset(String[] param) {
        /**
         * 当对象作为参数传递时，传递的是对象的引用
         * 因为string[]不是基本类型
         *
         * java最基本的原始数据类型
         *
         * int整型
         * double双精度实数类型
         * boolean布尔型
         * char字符型
         */
        param[0] = "hello, world!";
    }

    public static void main(String[] args) {
        int a=3,b=4;
//        swap(a, b);
//        System.out.println("main中a=" + a + "，b=" + b);

//        System.out.println("调用方法前a=" + a);
//        add(a);
//        System.out.println("调用方法后a=" + a);


        String[] array = new String[] {"huixin"};
        System.out.println("调用reset方法前array中的第0个元素的值是:" + array[0]);
        reset(array);
        System.out.println("调用reset方法后array中的第0个元素的值是:" + array[0]);
    }
}
