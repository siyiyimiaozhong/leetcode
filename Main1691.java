import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: siyiyimiaozhong
 * @Description: 1691. 堆叠长方体的最大高度
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1691.java
 * @CreateTime: 2022-12-11  00:57
 * @Version: 1.0
 */
public class Main1691 {
    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;
        for (int[] v : cuboids) {
            Arrays.sort(v);
        }
        Arrays.sort(cuboids, Comparator.comparingInt(a -> (a[0] + a[1] + a[2])));
        int ans = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = cuboids[i][2];
            for (int j = 0; j < i; j++) {
                if (cuboids[i][0] >= cuboids[j][0] &&
                        cuboids[i][1] >= cuboids[j][1] &&
                        cuboids[i][2] >= cuboids[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] cuboids = new int[][]{{50, 45, 20}, {95, 37, 53}, {45, 23, 12}};

        Main1691 main1691 = new Main1691();
        System.out.println(main1691.maxHeight(cuboids));
    }

}
