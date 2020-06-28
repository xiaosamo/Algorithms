package other.cache;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author yuan
 * @date 2020/3/18
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        LocalCache<String, String> cache = new LocalCache<>();
        String key = "aaa";
        cache.set(key, "bbb", 5);

        System.out.println(cache.get(key));
        cache.set("bbb", "cc", -1);


        while (cache.get("bbb") != null) {
            Thread.sleep(1000);
            System.out.println(cache.get(key));
            System.out.println(cache.get("bbb"));
        }



//        System.out.println(Instant.ofEpochMilli());

//        System.out.println(LocalDateTime.now());
    }
}
