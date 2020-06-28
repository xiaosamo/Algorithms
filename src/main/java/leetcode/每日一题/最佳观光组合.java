package leetcode.每日一题;

/**
 * @author yuan
 * @date 2020/6/17
 * https://leetcode-cn.com/problems/best-sightseeing-pair/solution/javade-3chong-jie-fa-by-sdwwld/
 */
public class 最佳观光组合 {
    /**
     * 1,根据公式res = A[i] + A[j] + i - j （i < j），我们求每个景点j的时候，他的A[j] - j 实际上是固定的，要想让res最大，我们就要想办法让A[i] + i尽可能大，所以代码很容易想到
     *
     * @return
     */
    public int maxScoreSightseeingPair(int[] A) {
        int res = 0, cur = A[0] + 0;
        for (int j = 1; j < A.length; ++j) {
            res = Math.max(res, cur + A[j] - j);
            cur = Math.max(cur, A[j] + j);
        }
        return res;
    }

}
