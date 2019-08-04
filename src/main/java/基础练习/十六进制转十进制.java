package 基础练习;

import java.util.Scanner;

public class 十六进制转十进制
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(Long.valueOf(str, 16));
    }
}
