package other.javabasice.reflect;

/**
 * @author yuan
 * @date 2019/3/19
 * @description
 */
public class ReferenceCounterProblem {
    static class MyObject{
        public MyObject childNode;
    }


    public static void main(String[] args) {
        MyObject object1 = new MyObject();
        MyObject object2 = new MyObject();

        object1.childNode = object2;
        object2.childNode = object1;

    }
}
