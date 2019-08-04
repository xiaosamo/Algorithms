package 牛客面试题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/4/11
 * @description
 */
public class possible_sentences {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.nextLine();
        String line = in.nextLine();
        String[] split = line.split(",");
        List<String>[] dict = new List[26];
//        catsanddog
//        cat,cats,and,sand,dog
        for (int i = 0; i < 26; i++) {
            dict[i] = new ArrayList<>();
        }
        for (String sp : split) {
            dict[sp.charAt(0) - 'a'].add(sp);
        }


        List<String> ans = new ArrayList<>();
        dfs(s, dict, 0, "", ans);
//        System.out.println(Arrays.toString(ans));
        ans.forEach(i -> System.out.println(i));

    }

    private static void dfs(String s, List<String>[] dict, int index, String res, List<String> ans) {


        if (index > s.length()) {
            return;
        }

        if (index == s.length()) {
            ans.add(res.substring(0, res.length() - 2));
//            ans.add(res.strip());

//            System.out.println(res);
            return;
        }

        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            for (String str : dict[c - 'a']) {
                if (index + str.length() <= s.length() && s.substring(index, index + str.length()).equals(str)) {
                    dfs(s, dict, index + str.length(), res + str + " ", ans);
                }
            }
        }

    }
}
