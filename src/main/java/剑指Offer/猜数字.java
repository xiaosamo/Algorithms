package 剑指Offer;

/**
 * @author yuan
 * @date 2019/10/5
 * @description
 */
public class 猜数字 {
    public int game(int[] guess, int[] answer) {
        int num = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                ++num;
            }
        }
        return num;
    }
}
