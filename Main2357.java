import java.util.HashSet;
import java.util.Set;

/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main2357.java
 * @CreateTime: 2023-02-24  09:13
 * @Version: 1.0
 */
public class Main2357 {

    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,0,3,5};

        Main2357 main2357 = new Main2357();
        System.out.println(main2357.minimumOperations(nums) == 3);
    }
}
