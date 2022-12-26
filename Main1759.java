/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1759.java
 * @CreateTime: 2022-12-26  09:49
 * @Version: 1.0
 */
public class Main1759 {

    private static final int MOD = 1000000007;

    public int countHomogenous(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        long res = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0 && chs[i - 1] != chs[i]) {
                res = (res + (cnt + 1) * cnt / 2) % MOD;
                cnt = 0;
            }
            cnt ++;
        }
        res = (res + (cnt + 1) * cnt / 2) % MOD;
        return (int)res;
    }

    public static void main(String[] args) {
        String s = "abbcccaa";

        Main1759 main1759 = new Main1759();
        System.out.println(main1759.countHomogenous(s) == 13);
    }
}
