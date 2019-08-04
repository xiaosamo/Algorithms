package 基础练习;

import java.util.Scanner;

public class 十进制转十六进制
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        long n = in.nextLong();

        System.out.println(Long.toHexString(n).toString().toUpperCase());
    }


}
