package utils.time;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author yuan
 * @date 2020/2/16
 */
public class 计算两个日期之间的天数和月数 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        LocalDate java8Release = LocalDate.of(2018, 12, 14);

        Period periodToNextJavaRelease = Period.between(today, java8Release);
        System.out.println("Months left between today and Java 8 release : "
                + periodToNextJavaRelease.getMonths() );


    }
}
