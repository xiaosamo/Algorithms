package 蓝桥杯.算法提高;

import java.util.Scanner;

public class P0102
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        //将16进制转为10进制
        int dec = Integer.parseInt(str, 16);
        String oct = Integer.toOctalString(dec);
        for (int i = oct.length(); i < 4; i++)
        {
            oct = '0' + oct;
        }


//        System.out.println("Hex: 0x" + Integer.toHexString(dec).toUpperCase());
        System.out.println("Hex: 0x" + str);
        System.out.println("Decimal: " + dec);
        System.out.println("Octal: " + oct);
    }
}
