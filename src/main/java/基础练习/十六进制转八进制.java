package 基础练习;

import java.util.Scanner;

public class 十六进制转八进制
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] result = new String[n + 1];
        for (int i = 0; i < n; i++)
        {
            //将16进制转为2进制
            String hex = in.next();
            StringBuilder bin = new StringBuilder();
            for (int j = 0; j < hex.length(); j++)
            {
                char c = hex.charAt(j);
                String b = Integer.toBinaryString(Integer.valueOf(String.valueOf(c), 16));

                for (int k = b.length(); k < 4; k++)
                {
                    b = '0' + b;
                }
                bin.append(b);
            }

//            System.out.println("bin=" + bin);
            //2进制转为8进制
            StringBuilder oct = new StringBuilder();
            int addZero = 3 - bin.length() % 3;
            //长度变为3的倍数，需要补的前导0的个数
            for (int p = 0; p < addZero; p++)
            {
                bin = new StringBuilder("0").append(bin);
            }

//            System.out.println("bin=" + bin);

            for (int m = 0; m < bin.length(); m += 3)
            {
                String temp = bin.substring(m, m + 3);
//                System.out.println("temp" + temp);
                String o = Integer.toOctalString(Integer.valueOf(temp, 2));
//                System.out.println("o=" + o);
                oct.append(o);
            }

//            System.out.println("oct=" + oct);
            result[i] = oct.toString().replaceAll("^(0+)","");    //用正则表达式去掉前导零

        }

        for (int i = 0; i < n; i++)
        {
            System.out.println(result[i]);
        }
    }
}
