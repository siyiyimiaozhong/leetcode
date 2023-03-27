/**
 * @ClassName: Main1638
 * @Auther: Chengxin Zhang
 * @Date: 2023/3/27 12:41
 * @Description: 1638. 统计只差一个字符的子串数目
 * @Version 1.0.0
 */
public class Main1638 {

    public int countSubstrings(String s, String t) {
        int n = s.length();
        int m = t.length();
        char[] sChs = s.toCharArray();
        char[] tChs = t.toCharArray();

        int[][] pre = new int[n + 1][m + 1];
        int[][] suf = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pre[i + 1][j + 1] = sChs[i] == tChs[j] ? pre[i][j] + 1 : 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                suf[i][j] = sChs[i] == tChs[j] ? suf[i + 1][j + 1] + 1 : 0;
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (sChs[i] != tChs[j]) {
                    res += (pre[i][j] + 1) * (suf[i + 1][j + 1] + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aba";
        String t = "baba";

        Main1638 main1638 = new Main1638();
        System.out.println(main1638.countSubstrings(s, t) == 6);
    }
}
