/**
 * @Author: Chengxin Zhang
 * @Description: 1605. 给定行和列的和求可行矩阵
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1605.java
 * @CreateTime: 2023-03-14  09:27
 * @Version: 1.0
 */
public class Main1605 {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        int[][] res = new int[n][m];

        int i = 0, j = 0;
        while (i < n && j < m){
            res[i][j] = Math.min(rowSum[i], colSum[j]);
            rowSum[i] -= res[i][j];
            colSum[j] -= res[i][j];
            if (rowSum[i] == 0) {
                i ++;
            }
            if (colSum[j] == 0) {
                j ++;
            }
        }
        return res;
    }

    public int[][] restoreMatrix2(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= res[i][j];
                colSum[j] -= res[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] rowSum = new int[]{3,8};
        int[] colSum = new int[]{4,7};

        Main1605 main1605 = new Main1605();
        int[][] res = main1605.restoreMatrix(rowSum, colSum);
        for (int[] re : res) {
            for (int i : re) {
                System.out.printf(i + " ");
            }
            System.out.println();
        }
    }
}
