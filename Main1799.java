/**
 * @Author: siyiyimiaozhong
 * @Description: 1799. N 次操作后的最大分数和
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1799.java
 * @CreateTime: 2022-12-22  09:38
 * @Version: 1.0
 */
public class Main1799 {

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int maxScore(int[] nums) {
        int n = nums.length;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                g[i][j] = gcd(nums[i], nums[j]);
            }
        }

        int m = (1 << n);
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            int cnt = Integer.bitCount(i);
            if ((cnt & 1) == 1) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) != 1) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (((i >> k) & 1) != 1) {
                        continue;
                    }
                    dp[i] = Math.max(dp[i], dp[i ^ (1 << j) ^ (1 << k)] + (cnt >> 1) * g[j][k]);
                }
            }
        }

        return dp[m - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};

        Main1799 main1799 = new Main1799();
        System.out.println(main1799.maxScore(nums) == 1);
    }
}
