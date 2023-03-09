/**
 * @Author: Chengxin Zhang
 * @Description: 2379. 得到 K 个黑块的最少涂色次数
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main2379.java
 * @CreateTime: 2023-03-09  09:32
 * @Version: 1.0
 */
public class Main2379 {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int res = Integer.MAX_VALUE;
        int[] arr = new int[n + 1];

        char[] chs = blocks.toCharArray();
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1];
            if (chs[i - 1] == 'B') {
                arr[i]++;
            }

            if (i - k >= 0) {
                res = Math.min(res, k - arr[i] + arr[i - k]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String blocks = "BWWWBB";
        int k = 6;

        Main2379 main2379 = new Main2379();
        System.out.println(main2379.minimumRecolors(blocks, k) == 3);
    }
}
