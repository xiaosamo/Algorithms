package nod51;

import java.util.Scanner;

public class 最小公倍数 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while (in.hasNext()) {
            long a = in.nextInt();
            long b = in.nextInt();
            if(a<b){ //保证a>b
                long t=a;a=b;b=t;
            }
            System.out.println(lcm(a, b));
        }
    }

    //最大公约数
    static long gcd(long a,long b){
        return a%b==0?b:gcd(b,a%b);
    }

    //最小公倍数
    static long lcm(long a, long b){
        return a*b/gcd(a,b);
    }
}
