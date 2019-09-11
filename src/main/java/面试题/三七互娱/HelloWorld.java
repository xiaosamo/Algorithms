package 面试题.三七互娱;

/**
 * @author yuan
 * @date 2019/9/8
 * @description
 */
class A {
    static{
        System.out.println("1");
    }
    public A(){
        System.out.println("2");
    }
}
class B extends A{
    static{
        System.out.println("a");
    }
    public B(){
        System.out.println("b");
    }
}

public class HelloWorld {
    /**
     * 1a2b2b
     * @param args
     */
    public static void main(String[] args) {
//        A a;
        A a = new B();
        a = new B();
    }
}
