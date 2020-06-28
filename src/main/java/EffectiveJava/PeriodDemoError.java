package EffectiveJava;

import java.util.Date;

/**
 * @author yuan
 * @date 2020/2/16
 * 错误实例
 * 1.Date过时，应该世家Instant或LocalDateTime
 * 2.应该对构造器参数进行保护性拷贝
 */
public final class PeriodDemoError {

    private final Date start;
    private final Date end;

    public PeriodDemoError(Date start, Date end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
        this.start = start;
        this.end = end;
    }


    public Date start() {
        return start;
    }

    public Date end() {
        return end;
    }

    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();


        PeriodDemoError p = new PeriodDemoError(start, end);

        end.setYear(78);
        System.out.println(p.start);
        System.out.println(p.end);
    }
}
