package 蓝桥杯.模拟;

/**
 * @author yuan
 * @date 2019/3/22
 * @description
 */
public class 加减乘 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] d = {0, 1, 2};

        int sum = 0;
        int sum2 = 0;
        int sum3 = 0;
        for (int i = 1; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                switch (d[j]) {
                    case 0:
                        sum += i;
                        break;
                    case 1:
                        sum *= i;
                        break;
                    case 2:
                        sum -= i;
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
