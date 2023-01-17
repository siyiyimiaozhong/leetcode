import java.util.HashMap;
import java.util.Map;

/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1814.java
 * @CreateTime: 2023-01-17  09:58
 * @Version: 1.0
 */
public class Main1814 {

    private static final int MOD = 1000000007;

    public int countNicePairs(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int x = num, tmp = 0;
            while (x > 0) {
                tmp = tmp * 10 + x % 10;
                x /= 10;
            }
            res = (res + map.getOrDefault(num - tmp, 0)) % MOD;
            map.put(num - tmp, map.getOrDefault(num - tmp, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{42, 11, 1, 97};

        Main1814 main1814 = new Main1814();
        System.out.println(main1814.countNicePairs(nums) == 2);
    }
}
