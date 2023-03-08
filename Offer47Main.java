/**
 * @Author: Chengxin Zhang
 * @Description: 剑指 Offer 47. 礼物的最大价值
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Offer47Main.java
 * @CreateTime: 2023-03-08  09:38
 * @Version: 1.0
 */
public class Offer47Main {
    public int maxValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] arr = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[j] = Math.max(arr[j], arr[Math.max(0, j - 1)]) + grid[i][j];
            }
        }
        return arr[m - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        Offer47Main main = new Offer47Main();
        System.out.println(main.maxValue(grid) == 12);
    }
}
