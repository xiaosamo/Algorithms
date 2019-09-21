package 负载均衡;

/**
 * @author yuan
 * @date 2019/9/17
 * @description
 */

public class Invoker {

    public Invoker(){

    }

    public Invoker(String ip, Integer weight) {
        this.ip = ip;
        this.weight = weight;
    }

    /**
     * 服务器ip
     */
    private String ip;
    /**
     * 权重
     */
    private Integer weight;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Invoker{" +
                "ip='" + ip + '\'' +
                ", weight=" + weight +
                '}';
    }
}
