package leetcode.每日一题;


/**
 * @author yuan
 * @date 2020/3/11
 * https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/solution/1013-jiang-shu-zu-fen-cheng-he-xiang-deng-de-san-2/
 */
public class 将数组分成和相等的三个部分 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        if (sum % 3 != 0) {
            return false;
        }

        int cur = 0, target = sum / 3, n = A.length;
        int i, j;
        for (i = 0; i < n; i++) {
            cur += A[i];
            if (cur == target) {
                break;
            }
        }
        if (cur != target) {
            return false;
        }
        //  # 需要满足最后一个数组非空
        for (j = i + 1; j < n - 1; j++) {
            cur += A[j];
            if (cur == target * 2) {
                return true;
            }
        }
        return false;
    }

}
