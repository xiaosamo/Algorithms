package 并发编程;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author yuan
 * @date 2020/2/12
 */
public class URLTest {

     public static void main(String[] args) {

        try (InputStream in = new URL("https://www.baidu.com/").openStream()) {

            in.transferTo(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
