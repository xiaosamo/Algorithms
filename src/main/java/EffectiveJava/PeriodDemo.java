package EffectiveJava;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author yuan
 * @date 2020/2/16
 * 使用LocalDateTime不可变对象
 */
public final class PeriodDemo {

    private final LocalDateTime start;
    private final LocalDateTime end;

    public PeriodDemo(LocalDateTime start, LocalDateTime end) {


        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }

        this.start = start;
        this.end = end;


    }


    public LocalDateTime start() {
        return start;
    }

    public LocalDateTime end() {
        return end;

    }

    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now();


        PeriodDemo p = new PeriodDemo(start, end);


//        end.plusSeconds(50000);

        // 第2种攻击
//        p.end().setYear(78);

        System.out.println(p.start);
        System.out.println(p.end);
    }
}
