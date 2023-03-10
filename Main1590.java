import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Chengxin Zhang
 * @Description: 1590. 使数组和能被 P 整除
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1590.java
 * @CreateTime: 2023-03-10  09:24
 * @Version: 1.0
 */
public class Main1590 {

    public int minSubarray(int[] nums, int p) {
        int sum = 0;
        for (int num : nums) {
            sum = (sum + num) % p;
        }
        if (sum % p == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int x = 0, res = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(x, i);
            int num = nums[i];
            x = (x + num) % p;
            int y = (x - sum + p) % p;
            if (map.containsKey(y)) {
                res = Math.min(res, i - map.get(y) + 1);
            }
        }
        return res == n ? -1 : res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 4, 2};
        int p = 6;

        Main1590 main1590 = new Main1590();
        System.out.println(main1590.minSubarray(nums, p) == 1);
    }

}
