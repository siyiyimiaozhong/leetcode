/**
 * @Author: Chengxin Zhang
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main2373.java
 * @CreateTime: 2023-03-01  09:30
 * @Version: 1.0
 */
public class Main2373 {

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        res[i][j] = Math.max(res[i][j], grid[x][y]);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}};

        Main2373 main2373 = new Main2373();
        // [[9,9],[8,6]]
        int[][] res = main2373.largestLocal(grid);
        for (int[] re : res) {
            for (int x : re) {
                System.out.print(x);
            }
            System.out.println();
        }
    }
}
