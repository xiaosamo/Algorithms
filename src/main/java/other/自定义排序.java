package other;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class 自定义排序
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        list.add("王硕");
        list.add("李明");
        list.add("刘迪");
        list.add("刘布");
        list.add("阿里");
        list.add("曹操");

        list2.add("abdsd");
        list2.add("cdfdsd");
        list2.add("fbdsd");
        list2.add("sdbdsd");
        list2.add("bdbdsd");

        //注意：是根据的汉字的拼音的字母排序的，而不是根据汉字一般的排序方法
        Collections.sort(list, Collator.getInstance(Locale.CHINA));
        //按字典序
        Collections.sort(list2);

        for (String s : list)
        {
            System.out.println(s);
        }

        for (String s : list2)
        {
            System.out.println(s);
        }
    }
}
