/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1250.java
 * @CreateTime: 2023-02-15  09:25
 * @Version: 1.0
 */
public class Main1250 {
    public boolean isGoodArray(int[] nums) {
        int res = nums[0];
        for (int num : nums) {
            res = gcd(res, num);
            if (res == 1) {
                break;
            }
        }
        return res == 1;
    }

    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{12, 5, 7, 23};

        Main1250 main1250 = new Main1250();
        System.out.println(main1250.isGoodArray(nums));
    }
}
