/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main2319.java
 * @CreateTime: 2023-01-31  09:09
 * @Version: 1.0
 */
public class Main2319 {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (((i == j || i == n - j - 1) && grid[i][j] == 0) || ((i != j && i != n - j - 1) && grid[i][j] != 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}};

        Main2319 main2319 = new Main2319();
        System.out.println(main2319.checkXMatrix(grid));
    }
}
