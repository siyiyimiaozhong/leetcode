/**
 * @ClassName: Main1092
 * @Auther: Chengxin Zhang
 * @Date: 2023/3/28 12:48
 * @Description: 1092. 最短公共超序列
 * @Version 1.0.0
 */
public class Main1092 {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        char[] str1Chs = str1.toCharArray();
        char[] str2Chs = str2.toCharArray();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            dp[i][m] = n - i;
        }
        for (int i = 0; i < m; i++) {
            dp[n][i] = m - i;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (str1Chs[i] == str2Chs[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (str1Chs[i] == str2Chs[j]) {
                sb.append(str1Chs[i]);
                i ++;
                j ++;
            } else if (dp[i][j] == dp[i + 1][j] + 1) {
                sb.append(str1Chs[i]);
                i ++;
            } else if (dp[i][j] == dp[i][j + 1] + 1) {
                sb.append(str2Chs[j]);
                j ++;
            }
        }

        if (i < n) {
            sb.append(str1.substring(i));
        } else if (j < m) {
            sb.append(str2.substring(j));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str1 = "abac", str2 = "cab";

        Main1092 main1092 = new Main1092();
        System.out.println(main1092.shortestCommonSupersequence(str1, str2).equals("cabac"));
    }
}
