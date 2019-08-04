package other.javabasice;

/**
 * @author yuan
 * @date 2019/3/3
 * @description
 */
public class StringTest {
    public static void main(String [] args)
    {
        String s1=new String("test");//创建2个对象，一个Class和一个堆里面
        String s2="test";//创建1个对象，s2指向pool里面的"test"对象
        String s3="test";//创建0个对象,指向s2指想pool里面的那个对象
        String s4=s2;//创建0个对象,指向s2,s3指想pool里面的那个对象
        String s5=new String("test");//创建1个对象在堆里面，注意，与s1没关系

        System.out.println(s2=="test");//true s2=="test"很明显true
        System.out.println(s2==s3);//true,因为指向的都是pool里面的那个"test"
        System.out.println(s2==s4);//true,同上,那么s3和s4...:)
        System.out.println(s1==s5);//false,很明显,false
        System.out.println(s1==s2);//false,指向的对象不一样,下面再说
        System.out.println(s1=="test");//false,难道s1!="tset"？下面再说

        System.out.println("---------------");

        s1=s2;
        System.out.println(s1=="test");//true,下面说
    }
}
