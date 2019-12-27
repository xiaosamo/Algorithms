package leetcode;

/**
 * @author yuan
 * @date 2019/12/27
 * @description
 */
public class IP地址无效化 {
    public String defangIPaddr(String address) {

        return address.replaceAll("\\.", "[.]");
    }
}
