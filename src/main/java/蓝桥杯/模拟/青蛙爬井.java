package 蓝桥杯.模拟;

/**
 * @author yuan
 * @date 2019/3/19
 * @description
 */
public class 青蛙爬井 {
    public static void main(String[] args) {
        int high = 60405;
        int d = 0;
        int sum = 0;
        // 注意d从1开始，if的位置！
        for (d = 1; ; d++) {
            sum += 105;
            if (sum >= high) {
                break;
            }
            sum -= 35;
        }
        System.out.println(d);
    }
}
