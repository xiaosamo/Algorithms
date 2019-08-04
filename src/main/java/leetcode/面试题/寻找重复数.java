package leetcode.面试题;

/**
 * @author yuan
 * @date 2019/3/6
 * @description 将数组看成链表，val是结点值也是下个节点的地址。因此这个问题就可以转换成判断链表有环，且找出入口节点---使用快慢指针
 */
public class 寻找重复数 {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            // 如果两个指针相遇，则陷入环
            if (slow == fast) {
                break;
            }
        }
        fast=0;
        while (true) {
            fast = nums[fast];
            slow = nums[slow];
            // 如果两指针相遇，则是环的入口
            if (slow == fast) {
                break;
            }
        }
        return fast;
    }

    public static void main(String[] args) {
        寻找重复数 obj = new 寻找重复数();
//        System.out.println(obj.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(obj.findDuplicate(new int[]{3,1,3,4,2}));
    }
}
