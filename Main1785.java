/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1785.java
 * @CreateTime: 2022-12-16  22:45
 * @Version: 1.0
 */
public class Main1785 {

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (int)((Math.abs(goal - sum) + limit - 1) / limit);
    }

    public static void main(String[] args) {
        int[] nums = {1,-1,1};
        int limit = 3;
        int goal = -4;

        Main1785 main1785 = new Main1785();
        System.out.println(main1785.minElements(nums, limit, goal) == 2);
    }
}
