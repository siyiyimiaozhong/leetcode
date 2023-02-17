/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1139.java
 * @CreateTime: 2023-02-17  09:23
 * @Version: 1.0
 */
public class Main1139 {
    public int largest1BorderedSquare(int[][] grid) {
        int xLen = grid.length;
        int yLen = grid[0].length;
        int[][] up = new int[xLen + 1][yLen + 1];
        int[][] left = new int[xLen + 1][yLen + 1];

        int res = 0;
        for (int i = 1; i <= xLen; i++) {
            for (int j = 1; j <= yLen; j++) {
                if (grid[i - 1][j - 1] == 1) {
                    up[i][j] = up[i - 1][j] + 1;
                    left[i][j] = left[i][j - 1] + 1;
                    int x = Math.min(up[i][j], left[i][j]);
                    while (up[i][j - x + 1] < x || left[i - x + 1][j] < x) {
                        x--;
                    }
                    res = Math.max(res, x);
                }
            }
        }
        return res * res;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

        Main1139 main1139 = new Main1139();
        System.out.println(main1139.largest1BorderedSquare(grid) == 9);
    }
}
