/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main813.java
 * @CreateTime: 2022-11-28  17:22
 * @Version: 1.0
 */
public class Main813 {

    public double largestSumOfAverages1(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        double[][] dp = new double[len][k];
        for (int i = 0; i < len; i++) {
            dp[i][0] = 1.0 * sum[i + 1] / (i + 1);
        }

        for (int i = 1; i < k; i++) {
            for (int j = i; j < len; j++) {
                for (int m = i - 1; m < j; m++) {
                    dp[j][i] = Math.max(dp[j][i], dp[m][i - 1] + 1.0 * (sum[j + 1] - sum[m + 1]) / (j - m));
                }
            }
        }
        return dp[len - 1][k - 1];
    }

    public double largestSumOfAverages2(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        double[][] dp = new double[len + 1][k + 1];
        for (int i = 1; i <= len; i++) {
            dp[i][1] = 1.0 * sum[i] / i;
        }

        for (int i = 2; i <= k; i++) {
            for (int j = i; j <= len; j++) {
                for (int m = i - 1; m < j; m++) {
                    dp[j][i] = Math.max(dp[j][i], dp[m][i - 1] + 1.0 * (sum[j] - sum[m]) / (j - m));
                }
            }
        }
        return dp[len][k];
    }

    public double largestSumOfAverages(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        double[] dp = new double[len + 1];
        for (int i = 1; i <= len; i++) {
            dp[i] = 1.0 * sum[i] / i;
        }

        for (int i = 2; i <= k; i++) {
            for (int j = len; j >= i; j--) {
                for (int m = i - 1; m < j; m++) {
                    dp[j] = Math.max(dp[j], dp[m] + 1.0 * (sum[j] - sum[m]) / (j - m));
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 4;

        Main813 main813 = new Main813();
        System.out.println(main813.largestSumOfAverages(arr, k));
    }
}
