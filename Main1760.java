import java.util.Arrays;

/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1760.java
 * @CreateTime: 2022-12-20  23:15
 * @Version: 1.0
 */
public class Main1760 {

    public int minimumSize(int[] nums, int maxOperations) {
        int l=1,r = Arrays.stream(nums).max().getAsInt();

        while (l < r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int num : nums) {
                cnt += (num - 1) / mid;
            }
            if (cnt <= maxOperations) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {9};
        int maxOperations = 2;

        Main1760 main1760 = new Main1760();
        System.out.println(main1760.minimumSize(nums, maxOperations));
        System.out.println(main1760.minimumSize(nums, maxOperations) == 3);
    }
}
