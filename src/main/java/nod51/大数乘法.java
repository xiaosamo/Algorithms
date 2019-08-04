package nod51;

import java.math.BigInteger;
import java.util.Scanner;

public class 大数乘法 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while (in.hasNext()) {
            BigInteger a = in.nextBigInteger();
            BigInteger b = in.nextBigInteger();
            System.out.println(a.multiply(b).toString());

        }
    }
}
