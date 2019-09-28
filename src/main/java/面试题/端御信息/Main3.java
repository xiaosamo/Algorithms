package 面试题.端御信息;

import java.io.File;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/26
 * @description
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        File directory = new File(s);
        try{
            // 绝对路径
//            System.out.println(directory.getAbsolutePath());
            // 相对路径
            System.out.println(directory.getCanonicalPath());
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
