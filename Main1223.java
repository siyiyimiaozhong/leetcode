/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1223.java
 * @CreateTime: 2023-02-10  09:35
 * @Version: 1.0
 */
public class Main1223 {

    private static final int MOD = 1000000007;

    public int dieSimulator(int n, int[] rollMax) {
        int[][] dp = new int[n + 1][6];
        int[] sum = new int[n + 1];
        sum[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 6; j++) {
                int pos = Math.max(i - rollMax[j] - 1, 0);
                int sub = (sum[pos] - dp[pos][j] + MOD) % MOD;
                dp[i][j] = (sum[i - 1] - sub + MOD) % MOD;
                if (i <= rollMax[j]) {
                    dp[i][j] = (dp[i][j] + 1) % MOD;
                }
                sum[i] = (sum[i] + dp[i][j]) % MOD;
            }
        }
        return sum[n];
    }

    public static void main(String[] args) {
        int n = 2;
        int[] rollMax = new int[]{1, 1, 2, 2, 2, 3};

        Main1223 main1223 = new Main1223();
        System.out.println(main1223.dieSimulator(n, rollMax) == 34);
    }
}
