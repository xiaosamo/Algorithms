package 紫书;

import java.util.*;

public class 反片语uva156
{
    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        List<String> words = new ArrayList<>(); //记录单词
        List<String> ans = new ArrayList<>(); //记录答案
        Map<String, Integer> map = new HashMap<>();
        String s;
        while ((s = in.next()).charAt(0) != '#')
        {
//            String s=in.next();
//            if ("#".equals(s)) break;
            words.add(s);
            String r = repr(s);
            if (!map.containsKey(r)) map.put(r, 1);
            else map.put(r, map.get(r) + 1);
//            System.out.println(repr(s));
        }
        for (int i = 0; i < words.size(); i++)
            if(map.get(repr(words.get(i)))==1)
                ans.add(words.get(i));
        Collections.sort(ans);
        for(String t:ans)
            System.out.println(t);

    }

    //将单词s转为小写后在排序
    private static String repr(String s)
    {
        char[] ch = s.toLowerCase().toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }

}
