/**
 * @Author: siyiyimiaozhong
 * @Description: 1752. 检查数组是否经排序和轮转得到
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1752.java
 * @CreateTime: 2022-11-27  11:54
 * @Version: 1.0
 */
public class Main1752 {

    public boolean check(int[] nums) {
        int x = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                x = i;
                break;
            }
        }
        if (x == 0) {
            return true;
        }

        for (int i = x + 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return nums[0] >= nums[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1, 2};

        Main1752 main1752 = new Main1752();
        System.out.println(main1752.check(arr));
    }
}
