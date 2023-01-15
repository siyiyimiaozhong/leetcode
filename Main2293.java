/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main2293.java
 * @CreateTime: 2023-01-15  22:30
 * @Version: 1.0
 */
public class Main2293 {
    public int minMaxGame(int[] nums) {
        int len = nums.length;
        while (len >= 2) {
            len >>= 1;
            for (int i = 0; i < len; i++) {
                if ((i & 1) == 0) {
                    nums[i] = Math.min(nums[i << 1], nums[i << 1 | 1]);
                } else {
                    nums[i] = Math.max(nums[i << 1], nums[i << 1 | 1]);
                }
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 2, 4, 8, 2, 2};

        Main2293 main2293 = new Main2293();
        System.out.println(main2293.minMaxGame(nums) == 1);
    }
}
