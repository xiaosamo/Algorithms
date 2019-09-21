/**
 * @author yuan
 * @date 2019/9/20
 * @description
 */
public class Demo {

    private static Demo demo;

    public Demo(){
        System.out.println("new,demo=" + demo);
    }

    public Demo(Demo d){
        demo = d;
    }



    {
        System.out.println("bolck=" + demo);
    }
    static {
        System.out.println("static");
        System.out.println("demo=" + demo);

    }


    public static void main(String[] args) {
        Demo demo = new Demo(new Demo());

    }
}
