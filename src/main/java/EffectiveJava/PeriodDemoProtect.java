package EffectiveJava;

import java.util.Date;

/**
 * @author yuan
 * @date 2020/2/16
 * 对构造器参数进行保护性拷贝
 */
public final class PeriodDemoProtect {

    private final Date start;
    private final Date end;

    public PeriodDemoProtect(Date start, Date end) {

        // 修改
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        // 注意，保护性拷贝是在检查参数之前的
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
    }


    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());

    }

    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();


        PeriodDemoProtect p = new PeriodDemoProtect(start, end);

        // 第2种攻击
        p.end().setYear(78);

        System.out.println(p.start);
        System.out.println(p.end);
    }
}
