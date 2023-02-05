import java.util.Arrays;

/**
 * @Author: siyiyimiaozhong
 * @Description: 1210. 穿过迷宫的最少移动次数
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1210.java
 * @CreateTime: 2023-02-05  16:02
 * @Version: 1.0
 */
public class Main1210 {
    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        int[][][] dis = new int[n][n][2];
        int maxValue = n * n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dis[i][j], maxValue);
            }
        }
        dis[0][0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean x = j + 1 < n && grid[i][j] == 0 && grid[i][j + 1] == 0;
                boolean y = i + 1 < n && grid[i][j] == 0 && grid[i + 1][j] == 0;

                // 0
                if (x) {
                    if (i - 1 >= 0) {
                        dis[i][j][0] = Math.min(dis[i][j][0], dis[i - 1][j][0] + 1);
                    }
                    if (j - 1 >= 0) {
                        dis[i][j][0] = Math.min(dis[i][j][0], dis[i][j - 1][0] + 1);
                    }
                }
                // 1
                if (y) {
                    if (i - 1 >= 0) {
                        dis[i][j][1] = Math.min(dis[i][j][1], dis[i - 1][j][1] + 1);
                    }
                    if (j - 1 >= 0) {
                        dis[i][j][1] = Math.min(dis[i][j][1], dis[i][j - 1][1] + 1);
                    }
                }
                // 旋转
                if (x && y && grid[i + 1][j + 1] == 0) {
                    dis[i][j][0] = Math.min(dis[i][j][0], dis[i][j][1] + 1);
                    dis[i][j][1] = Math.min(dis[i][j][1], dis[i][j][0] + 1);
                }
            }
        }

        return dis[n - 1][n - 2][0] >= maxValue ? -1 : dis[n - 1][n - 2][0];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]
                {{0, 0, 0, 0, 0, 1},
                        {1, 1, 0, 0, 1, 0},
                        {0, 0, 0, 0, 1, 1},
                        {0, 0, 1, 0, 1, 0},
                        {0, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 0, 0}};

        Main1210 main1210 = new Main1210();
        System.out.println(main1210.minimumMoves(grid) == 11);

    }
}
