/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1802.java
 * @CreateTime: 2023-01-04  09:13
 * @Version: 1.0
 */
public class Main1802 {

    public int maxValue(int n, int index, int maxSum) {
        int l = 0, r = 1000000000;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid, n, index, maxSum)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public boolean check(int mid, int n, int index, int maxSum) {
        int right = n - index - 1;
        return mid + cal(mid, index) + cal(mid, right) <= maxSum;
    }

    public long cal(int big, int length) {
        if (length + 1 < big) {
            int small = big - length;
            return (long) (big - 1 + small) * length / 2;
        } else {
            int ones = length - (big - 1);
            return (long) big * (big - 1) / 2 + ones;
        }
    }

    public static void main(String[] args) {
        int n = 8;
        int index = 7;
        int maxSum = 14;

        Main1802 main1802 = new Main1802();
        System.out.println(main1802.maxValue(n, index, maxSum));
        System.out.println(main1802.maxValue(n, index, maxSum) == 4);
    }
}
