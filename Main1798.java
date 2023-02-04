import java.util.Arrays;

/**
 * @Author: siyiyimiaozhong
 * @Description: 1798. 你能构造出连续值的最大数目
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1798.java
 * @CreateTime: 2023-02-04  14:32
 * @Version: 1.0
 */
public class Main1798 {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int res = 1;
        for (int coin : coins) {
            if (coin > res) {
                return res;
            }
            res += coin;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,4,10,3,1};

        Main1798 main1798 = new Main1798();
        System.out.println(main1798.getMaximumConsecutive(coins) == 20);
    }
}
