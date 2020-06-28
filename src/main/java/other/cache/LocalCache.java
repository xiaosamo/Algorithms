package other.cache;


import java.time.Instant;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yuan
 * @date 2020/3/18
 */
public class LocalCache<K,V> implements Cacheable<K,V>{

    // 缓存数据的集合
    private Map<K, Data> map = new ConcurrentHashMap<>();

    // 每60s请理过期数据，延迟1s执行
    public LocalCache(){
        Timer t = new Timer();
        t.schedule(new ExpiringChecker(), 1000, 60 * 1000);
    }


    @Override
    public V get(K key) {
        Data data = map.get(key);
        if (isExpired(data)) {
            delete(key);
            return null;
        }
        return data.getVal();
    }

    private boolean isExpired(Data data) {
        if (data == null) {
            return true;
        }
        return data.getExpire() > 0 && Instant.now().toEpochMilli() > data.getExpire();
    }

    /**
     * 添加数据
     * @param key
     * @param val
     * @param expire 过期时间，单位s
     */
    @Override
    public void set(K key, V val, long expire) {
        map.put(key, new Data(val, expire));
    }

    @Override
    public void delete(K key) {
        map.remove(key);
    }

    @Override
    public boolean exist(K key) {
        return map.containsKey(key);
    }

    // 数据包装类，保存val的时间戳
    private class Data{
        V val;
        long expire;

        Data(V val, long expire) {
            this.val = val;
            this.expire = expire > 0 ? Instant.now().toEpochMilli() + expire * 1000 : expire;
        }

        public V getVal() {
            return val;
        }

        public void setVal(V val) {
            this.val = val;
        }

        public long getExpire() {
            return expire;
        }

        public void setExpire(long expire) {
            this.expire = expire;
        }
    }

    /**
     * 过期数据检测器
     */
    private class ExpiringChecker extends TimerTask{

        @Override
        public void run() {
            map.forEach((k, v) -> {
                if (isExpired(v)) {
                    delete(k);
                }
            });
        }
    }
}
