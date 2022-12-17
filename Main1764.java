/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1764.java
 * @CreateTime: 2022-12-17  21:41
 * @Version: 1.0
 */
public class Main1764 {

    public boolean canChoose(int[][] groups, int[] nums) {
        int p1 = 0, n = nums.length;
        for (int[] g : groups) {
            int p2 = 0;
            while (p2 < g.length && p1 < n) {
                if (nums[p1++] == g[p2]) {
                    p2++;
                } else {
                    p1 -= p2;
                    p2 = 0;
                }
            }
            if (p1 >= n && p2 != g.length) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] groups = new int[][]{{1, -1, -1}, {3, -2, 0}};
        int[] nums = new int[]{1, -1, 0, 1, -1, -1, 3, -2, 0};

        Main1764 main1764 = new Main1764();
        System.out.println(main1764.canChoose(groups, nums) == true);
    }
}
