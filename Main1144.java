/**
 * @Author: siyiyimiaozhong
 * @Description: 1144. 递减元素使数组呈锯齿状
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1144.java
 * @CreateTime: 2023-02-27  09:19
 * @Version: 1.0
 */
public class Main1144 {
    public int movesToMakeZigzag(int[] nums) {
        return Math.min(fun(nums, 0), fun(nums, 1));
    }

    private int fun(int[] nums, int x) {
        int res = 0;
        int n = nums.length;
        for (int i = x; i < n; i += 2) {
            int cnt = 0;
            if (i - 1 >= 0) {
                cnt = Math.max(cnt, nums[i] - nums[i - 1] + 1);
            }
            if (i + 1 < n) {
                cnt = Math.max(cnt, nums[i] - nums[i + 1] + 1);
            }
            res += cnt;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};

        Main1144 main1144 = new Main1144();
        System.out.println(main1144.movesToMakeZigzag(nums) == 2);
    }
}
