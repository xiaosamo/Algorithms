package 紫书;

import java.util.Arrays;
import java.util.Scanner;

public class 全排列2字符串 {
    public static void permutation1(String str ,String cur ,int len){
        /* 全排列 递归实现
      递归树：
          str:          a            b                c
                      ab ac         ba   bc         ca   cb
        result:        abc acb        bac    bca      cab   cba
         */

        //结果 开始传入""   空字符进入   len   是这个数的长度
        if(cur.length()==len){            //表示遍历完了一个全排列结果
            System.out.println(cur);
        }
        else{
            for(int i=0;i<str.length();i++){
                if(cur.indexOf(str.charAt(i))<0){    //返回指定字符在此字符串中第一次出现处的索引。
                    //System.out.println("字母："+str.charAt(i));
                    permutation1(str, cur+str.charAt(i), len);
                }
            }
        }
    }
    public static void permutation2(String str ,String cur){
        /* 全排列 递归实现
      递归树：
          str:          a            b                c
                      ab ac         ba   bc         ca   cb
        result:        abc acb        bac    bca      cab   cba
         */

        //结果 开始传入""   空字符进入   len   是这个数的长度
        if(cur.length()==str.length()){            //表示遍历完了一个全排列结果
            System.out.println(cur);
        }
        else{
            for(int i=0;i<str.length();i++){
                if(cur.indexOf(str.charAt(i))<0){    //返回指定字符在此字符串中第一次出现处的索引。
                    //System.out.println("字母："+str.charAt(i));
                    permutation2(str, cur+str.charAt(i));
                }
            }
        }
    }



    public static void main(String args[]) throws Exception {
        String s = "123";
//        permutation1(s, "", s.length());
        permutation2(s, "");
    }
}
