import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Main2367
 * @Auther: Chengxin Zhang
 * @Date: 2023/3/31 13:34
 * @Description:
 * @Version 1.0.0
 */
public class Main2367 {
    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (set.contains(num - diff) && set.contains(num + diff)) {
                res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,4,6,7,10};
        int diff = 3;

        Main2367 main2367 = new Main2367();
        System.out.println(main2367.arithmeticTriplets(nums, diff) == 2);
    }
}
