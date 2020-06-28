package utils.time;

import java.time.Instant;

/**
 * @author yuan
 * @date 2020/2/16
 */
public class 获取当前的时间戳 {
    public static void main(String[] args) {
        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp.toEpochMilli());
    }
}
