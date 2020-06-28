package utils.time;

import java.time.LocalDate;

/**
 * @author yuan
 * @date 2020/2/16
 * 文章地址
 * https://mp.weixin.qq.com/s/fv2lXzY468RWjndso9uQbg
 */
public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        System.out.println("今天的日期:"+today);

        // 获取年月日
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();

        System.out.println("year:"+year);
        System.out.println("month:"+month);
        System.out.println("day:"+day);

        System.out.println();

        // 可以调用另一个有用的工厂方法LocalDate.of()创建任意日期
        LocalDate date = LocalDate.of(2018,2,6);
        System.out.println("自定义日期:"+date);
    }

}
