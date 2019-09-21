package 剑指Offer;

import java.util.BitSet;

/**
 * @author yuan
 * @date 2019/9/21
 * @description
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * https://www.nowcoder.com/discuss/198840?type=post&order=time&pos=&page=2
 */
public class 第一个只出现一次的字符 {
    public int FirstNotRepeatingChar(String str) {
        int[] cnts = new int[256];
        for (int i = 0; i < str.length(); i++) {
            cnts[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (cnts[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 以上实现的空间复杂度还不是最优的。考虑到只需要找到只出现一次的字符，那么需要统计的次数信息只有 0,1,更大，使用两个比特位就能存储这些信息。
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar2(String str) {
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);

        for (char c : str.toCharArray()) {
            if (!bs1.get(c) && !bs2.get(c)) {
                bs1.set(c);  // 0 0 -> 0 1
            } else if (bs1.get(c) && !bs2.get(c)) {
                bs2.set(c);  // 0 1 -> 1 1
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (bs1.get(c) && !bs2.get(c)) {
                return i;
            }
        }
        return -1;
    }
}
