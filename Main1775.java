/**
 * @Author: siyiyimiaozhong
 * @Description: 1775. 通过最少操作次数使数组的和相等
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1775.java
 * @CreateTime: 2022-12-07  09:37
 * @Version: 1.0
 */
public class Main1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length * 6 < nums2.length || nums2.length * 6 < nums1.length) {
            return -1;
        }
        int[] cnt1 = new int[7];
        int[] cnt2 = new int[7];
        int sum = 0;
        for (int x : nums1) {
            sum += x;
            cnt1[x] ++;
        }
        for (int x : nums2) {
            sum -= x;
            cnt2[x] ++;
        }
        if (sum > 0) {
            return fun(cnt2, cnt1, sum);
        }
        return fun(cnt1, cnt2, -sum);
    }

    private int fun(int[] cnt1, int[] cnt2, int sum) {
        int[] cnt = new int[7];
        for (int i = 1; i < 7; i++) {
            cnt[6 - i] += cnt1[i];
            cnt[i - 1] += cnt2[i];
        }
        int res = 0;
        for (int i = 5; i > 0 && sum > 0; i--) {
            int x = Math.min((sum + i - 1) / i, cnt[i]);
            res += x;
            sum -= i * x;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] num2 = new int[]{1, 1, 2, 2, 2, 2};

        Main1775 main1775 = new Main1775();
        System.out.println(main1775.minOperations(num1, num2) == 3);
    }
}
