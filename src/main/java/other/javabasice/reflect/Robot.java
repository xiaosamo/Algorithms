package other.javabasice.reflect;

/**
 * @author yuan
 * @date 2019/3/17
 * @description
 */
public class Robot {
    static {
        System.out.println("Hello Robot");
    }
    private String name;

    public void sayHello(String s) {
        System.out.println(s + " " + name);
    }
    // 私有
    private String throwHello(String tag) {
        return "Hello " + tag;
    }
}
