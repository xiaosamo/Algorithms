package 蓝桥杯.模拟;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yuan
 * @date 2019/3/19
 * @description
 * 一天蒜头君 22:28:45 开始睡觉，06:24:26 醒来之后，蒜头君在想，今天我睡了多久？
 * 24:00:00 - 22:28:45 = 1:31:15
 * 1:31:15 + 06:24:26 = 07:55:41
 */
public class 钟表 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d1 = format.parse("2019-3-19 22:28:45");
        Date d2 = format.parse("2019-3-20 06:24:26");


        //这样得到的差值是毫秒级别
        long t = d2.getTime() - d1.getTime();

        // 秒
        t /= 1000;

        System.out.println(t);

        long h = t / 3600;
        long m = t / 60 % 60;
        long s = t % 60;


        System.out.println(h);
        System.out.println(m);
        System.out.println(s);


//
        System.out.println("/*请在这里填入答案*/");
    }
}
