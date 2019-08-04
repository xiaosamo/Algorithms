package hdu;

/**
 * 思路：汉字机内码在计算机的表达方式的描述是，使用二个字节，每个字节最高位一位为1。计算机中， 补码第一位是符号位， 1 表示为负数，所以汉字机内码的每个字节表示的十进制数都是负数，且汉字占用两个字节结果要除以2，不要忘了大笑。
 */

import java.util.Scanner;

public class Main2030
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine(); //注意吸收换行符

        while (n-- > 0)
        {
            String s = in.nextLine();
//            System.out.println(s);
            byte[] b = s.getBytes(); //将字符串转化为字节数组

            int count = 0;
            for (int i = 0; i < b.length; i++)
            {
                if (b[i] < 0)
                {
                    count++;
                }
            }

            System.out.println(count/2);

        }
    }

}
