/**
 * @Author: siyiyimiaozhong
 * @Description: 1827. 最少操作使数组递增
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1827.java
 * @CreateTime: 2022-12-11  15:11
 * @Version: 1.0
 */
public class Main1827 {
    public int minOperations(int[] nums) {
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                continue;
            }
            res += nums[i - 1] + 1 - nums[i];
            nums[i] = nums[i - 1] + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};

        Main1827 main1827 = new Main1827();
        System.out.println(main1827.minOperations(nums) == 3);
    }
}
