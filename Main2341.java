import java.util.HashMap;
import java.util.Map;

/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main2341.java
 * @CreateTime: 2023-02-16  09:30
 * @Version: 1.0
 */
public class Main2341 {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[2];
        map.forEach((key, value) -> {
            res[0] += value / 2;
            res[1] += value % 2;
        });
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,1,3,2,2};

        Main2341 main2341 = new Main2341();
        int[] res = main2341.numberOfPairs(nums);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
