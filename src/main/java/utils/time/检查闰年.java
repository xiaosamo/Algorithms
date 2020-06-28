package utils.time;

import java.time.LocalDate;

/**
 * @author yuan
 * @date 2020/2/16
 */
public class 检查闰年 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        if(today.isLeapYear()){
            System.out.println("This year is Leap year");
        }else {
            System.out.println("2018 is not a Leap year");
        }
    }
}
