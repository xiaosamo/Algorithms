package utils.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author yuan
 * @date 2020/2/16
 */
public class 解析或格式化日期 {
    public static void main(String[] args) {
        String dayAfterTommorrow = "20180205";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(dayAfterTommorrow+"  格式化后的日期为:  "+formatted);
    }
}
