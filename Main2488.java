import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Chengxin Zhang
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main2488.java
 * @CreateTime: 2023-03-16  09:32
 * @Version: 1.0
 */
public class Main2488 {
    public int countSubarrays(int[] nums, int k) {
        int idx = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                idx = i;
                break;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0, x = 0;
        for (int i = 0; i < n; i++) {
            x += Integer.compare(nums[i], k);
            if (i < idx) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            } else {
                int y = map.getOrDefault(x, 0);
                int z = map.getOrDefault(x - 1, 0);
                res += y + z;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,4,5};
        int k = 4;

        Main2488 main2488 = new Main2488();
        System.out.println(main2488.countSubarrays(nums, k) == 3);
    }
}
