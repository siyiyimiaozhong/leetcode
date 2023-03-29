import java.util.Arrays;

/**
 * @ClassName: Main1641
 * @Auther: Chengxin Zhang
 * @Date: 2023/3/29 21:39
 * @Description: 1641. 统计字典序元音字符串的数目
 * @Version 1.0.0
 */
public class Main1641 {
    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return Arrays.stream(dp).sum();
    }

    public static void main(String[] args) {
        int n = 2;

        Main1641 main1641 = new Main1641();
        System.out.println(main1641.countVowelStrings(n) == 15);
    }
}
