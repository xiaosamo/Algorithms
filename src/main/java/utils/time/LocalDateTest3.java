package utils.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author yuan
 * @date 2020/2/16
 * 文章地址
 * https://mp.weixin.qq.com/s/fv2lXzY468RWjndso9uQbg
 */
public class LocalDateTest3 {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.of(2018,2,6);

        if(tomorrow.isAfter(today)){
            System.out.println("之后的日期:"+tomorrow);
        }

        LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
        if(yesterday.isBefore(today)){
            System.out.println("之前的日期:"+yesterday);
        }
    }

}
