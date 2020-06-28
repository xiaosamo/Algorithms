package utils.time;

import java.time.Clock;

/**
 * @author yuan
 * @date 2020/2/16
 * Java 8增加了一个Clock时钟类用于获取当时的时间戳，或当前时区下的日期时间信息。以前用到System.currentTimeInMillis()和TimeZone.getDefault()的地方都可用Clock替换
 */
public class ClockTest {
    public static void main(String[] args) {
        Clock clock = Clock.systemUTC();
        System.out.println("Clock : " + clock.millis());

        Clock defaultClock = Clock.systemDefaultZone();
        System.out.println("Clock : " + defaultClock.millis());
    }
}
