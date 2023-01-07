import java.util.Arrays;

/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1658.java
 * @CreateTime: 2023-01-07  18:22
 * @Version: 1.0
 */
public class Main1658 {

    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum < x) {
            return -1;
        }

        int l = -1, r = 0, ls = 0, rs = sum;
        int res = n + 1;
        while (l < n) {
            if (l != -1) {
                ls += nums[l];
            }
            while(r < n && ls + rs > x) {
                rs -= nums[r];
                r ++;
            }
            if (ls + rs == x) {
                res = Math.min(res, l + 1 + n - r);
            }
            l ++;
        }
        return res == n + 1 ? -1 : res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,4,2,3};
        int x = 5;

        Main1658 main1658 = new Main1658();
        System.out.println(main1658.minOperations(nums, x) == 5);
    }
}
