package 剑指Offer;

/**
 * @author yuan
 * @date 2019/10/5
 * @description
 */
public class 宝石与石头 {
    public int numJewelsInStones(String J, String S) {
        int num = 0;
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < J.length(); j++) {
                if (S.charAt(i) == J.charAt(j)) {
                    ++num;
                }
            }
        }
        return num;

    }
}
