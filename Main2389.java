import java.util.Arrays;

/**
 * @Author: Chengxin Zhang
 * @Description: 2389. 和有限的最长子序列
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main2389.java
 * @CreateTime: 2023-03-17  09:53
 * @Version: 1.0
 */
public class Main2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length, m = queries.length;
        Arrays.sort(nums);
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = search(sum, queries[i]) - 1;
        }
        return res;
    }

    private int search(int[] sum, int query) {
        int l = 1, r = sum.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (sum[mid] > query) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 2, 1};
        int[] queries = new int[]{3, 10, 21};

        Main2389 main2389 = new Main2389();
        int[] res = main2389.answerQueries(nums, queries);
        Arrays.stream(res).forEach(System.out::println);
    }
}
