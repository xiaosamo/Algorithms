package 面试题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yuanshijia
 * @date 2019-08-16
 * @description
 */
public class 大整数乘法 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int l1 = num1.length();
        int l2 = num2.length();
        int[] nums = new int[l1 + l2];
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int t = nums[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                nums[i + j + 1] = t % 10; //当前进位
                nums[i + j] += t / 10;  //前一位加上进位
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean zero = true;
        for (int i = 0; i < l1 + l2; i++) {
            if (zero && nums[i] == 0) {
                continue;
            }
            zero = false;
            sb.append(nums[i]);
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        System.out.println(new 大整数乘法().multiply("123", "45"));
        System.out.println(new 大整数乘法().multiply("123", "0"));
    }

}
