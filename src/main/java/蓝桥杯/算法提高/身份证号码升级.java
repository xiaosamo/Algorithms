package 蓝桥杯.算法提高;

import java.util.Scanner;

public class 身份证号码升级
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int[] a = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        int sum=0;

        char[] c = {'1', '0', 'x', '9', '8', '7', '6', '5', '4', '3', '2'};

        String str = in.nextLine();
        StringBuilder sb = new StringBuilder();

        sb.append(str).insert(6, "19");
        for (int i = 0; i < 17; i++)
        {
            int t = sb.charAt(i) - '0';
            sum += t * a[i];
        }
        int result = sum % 11;
        System.out.println(sb.toString() + c[result]);
    }
}
