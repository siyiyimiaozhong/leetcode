/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1803.java
 * @CreateTime: 2023-01-05  09:20
 * @Version: 1.0
 */
public class Main1803 {

    public class Tire {
        public Tire[] children = new Tire[2];
        public int sum;
    }

    private Tire root;
    private static final int CNT = 16;

    public int countPairs(int[] nums, int low, int high) {
        return fun(nums, high) - fun(nums, low - 1);
    }

    private int fun(int[] nums, int max) {
        this.root = new Tire();
        int res = 0;
        for (int num : nums) {
            this.add(num);
            res += get(num, max);
        }
        return res;
    }

    private void add(int x) {
        Tire cur = root;
        for (int i = CNT; i >= 0; i--) {
            int y = (x >> i) & 1;
            if (cur.children[y] == null) {
                cur.children[y] = new Tire();
            }
            cur = cur.children[y];
            cur.sum ++;
        }
    }

    private int get(int num, int x) {
        Tire cur = root;
        int sum = 0;
        for (int i = CNT; i >= 0; i--) {
            int y = (num >> i) & 1;
            if (((x >> i) & 1) == 1) {
                if (cur.children[y] != null) {
                    sum += cur.children[y].sum;
                }
                if (cur.children[y ^ 1] == null) {
                    return sum;
                }
                cur = cur.children[y ^ 1];
            } else {
                if (cur.children[y] == null) {
                    return sum;
                }
                cur = cur.children[y];
            }
        }
        sum += cur.sum;
        return sum;
    }

    public static void main(String[] args) {
        // nums = [1,4,2,7], low = 2, high = 6
        int[] nums = new int[] {1, 4, 2, 7};
        int low = 2;
        int high = 6;

        Main1803 main1803 = new Main1803();
        System.out.println(main1803.countPairs(nums, low, high) == 6);
    }
}
