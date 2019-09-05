package 面试题;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/9/3
 * @description
 * https://www.nowcoder.com/test/question/done?tid=27034205&qid=174873#summary
 * 知某次聚会敏感词有N个人参加，这N个人来自26个地区，现在将26个地区使用数字0-25表示，使用整数数组Locations存储这N个人的地区, 请返回一个bool值, True代表所有人的地区全都不同，False代表存在相同地区。要求：不能使用额外的存储结构。
 */
public class _26个不同地区 {
    public boolean checkDifferent(int[] locations) {
        if (locations.length > 26) {
            return false;
        }
        for (int i = 0; i < locations.length; i++) {
            for (int j = locations.length - 1; j > i; j--) {
                if (locations[i] == locations[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkDifferent2(int[] locations) {
        Arrays.sort(locations);
        for (int i = 0; i < locations.length - 1; i++) {
            if (locations[i] == locations[i + 1]) {
                return false;
            }
        }
        return true;
    }
}


