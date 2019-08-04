package hdu;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main1063
{
    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        while (in.hasNext())
        {
            BigDecimal a = in.nextBigDecimal();
            int n = in.nextInt();

            //stripTrailingZeros去掉后缀0，toPlainString表示形式不带指数字段,然后用正则去掉小数点前的0
            System.out.println(a.pow(n).stripTrailingZeros().toPlainString().replaceAll("^(0.)","."));

            //结果一样的
//            BigDecimal b = a;
//            for (int i = 1; i < n; i++)
//            {
//                a = a.multiply(b);
//            }
//            System.out.println(a);
        }

    }


}
