/**
 * @Author: Chengxin Zhang
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1615.java
 * @CreateTime: 2023-03-15  09:28
 * @Version: 1.0
 */
public class Main1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] map = new boolean[n][n];
        int[] cnt = new int[n];
        for (int[] road : roads) {
            map[road[0]][road[1]] = true;
            map[road[1]][road[0]] = true;
            cnt[road[0]] ++;
            cnt[road[1]] ++;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = cnt[i] + cnt[j] - (map[i][j] ? 1 : 0);
                res = Math.max(res, x);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] roads = new int[][]{{0,1},{0,3},{1,2},{1,3}};

        Main1615 main1615 = new Main1615();
        System.out.println(main1615.maximalNetworkRank(n, roads) == 4);
    }
}