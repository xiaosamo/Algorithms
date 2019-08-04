package leetcode;

import java.nio.ByteBuffer;

/**
 * @author yhf
 * @date 2019/5/5
 * @description
 */
public class 到达终点数字 {
    private int sum = 0;
    private int dep = 0;
    public int reachNumber(int target) {

        dfs(target, 1);

        return dep;
    }

    private void dfs(int target, int cur) {
        if (sum == target) {
            return;
        }

        ++dep;
        sum += cur;

//        System.out.println("cur = " + cur);
        if (sum > target) {
            sum -= 2 * cur;
        }
        dfs(target, cur + 1);
    }


    public static void main(String[] args) {
        到达终点数字 obj = new 到达终点数字();
        System.out.println(obj.reachNumber(3));
        System.out.println(obj.reachNumber(2));
//        DirectByteBuffe


    }
}
