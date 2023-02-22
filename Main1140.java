/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1140.java
 * @CreateTime: 2023-02-22  12:19
 * @Version: 1.0
 */
public class Main1140 {

    public int stoneGameII(int[] piles) {
        int n = piles.length, sum = 0;
        int[][] arr = new int[n][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            sum += piles[i];
            for (int j = 1; j <= n; j++) {
                if (i + 2 * j >= n) {
                    arr[i][j] = sum;
                } else {
                    for (int x = 1; x <= 2 * j; x++) {
                        arr[i][j] = Math.max(arr[i][j], sum - arr[i + x][Math.max(j, x)]);
                    }
                }
            }
        }
        return arr[0][1];
    }

    public static void main(String[] args) {
        int[] piles = new  int[]{2,7,9,4,4};

        Main1140 main1140 = new Main1140();
        System.out.println(main1140.stoneGameII(piles) == 10);
    }
}
