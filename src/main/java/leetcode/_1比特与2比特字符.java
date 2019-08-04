package leetcode;

/**
 * @author yhf
 * @date 2019/5/5
 * @description
 */
public class _1比特与2比特字符 {
    public boolean isOneBitCharacter(int[] bits) {
        return dfs(bits, 0);
    }

    private boolean dfs(int[] bits, int i) {
        if (i >= bits.length) {
            return false;
        }
        if (bits[i] == 0 && i == bits.length - 1) {
            return true;
        }

        if (bits[i] == 1) {
            return dfs(bits, i + 2);
        } else {
            // 0
            return dfs(bits, i + 1);
        }
    }

    public static void main(String[] args) {
        _1比特与2比特字符 obj = new _1比特与2比特字符();
        System.out.println(obj.isOneBitCharacter(new int[]{1, 0, 0}));
        System.out.println(obj.isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }
}
