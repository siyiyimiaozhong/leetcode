import java.util.Arrays;

/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main.java
 * @CreateTime: 2023-01-14  23:49
 * @Version: 1.0
 */
public class Main1819 {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        boolean[] arr = new boolean[max + 1];
        for (int num : nums) {
            arr[num] = true;
        }
        int res = 0;
        for (int i = 1; i <= max; i++) {

            int x = 0;
            for (int j = i; j <= max; j += i) {
                if (!arr[j]) {
                    continue;
                }
                if (0 == x) {
                    x = j;
                } else {
                    x = gcd(x, j);
                }
                if (x == i) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6, 10, 3};

        Main1819 main1819 = new Main1819();
        System.out.println(main1819.countDifferentSubsequenceGCDs(nums) == 5);
    }
}
