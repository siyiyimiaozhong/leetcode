/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1234.java
 * @CreateTime: 2023-02-13  09:26
 * @Version: 1.0
 */
public class Main1234 {
    public int balancedString(String s) {
        char[] chs = s.toCharArray();
        int[] cnt = new int[26];

        for (char ch : chs) {
            cnt[ch - 'A']++;
        }

        int l = 0, r = 0, n = s.length();
        int x = n / 4;
        if (check(cnt, x)) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        while (l < n) {
            while (r < n && !check(cnt, x)) {
                cnt[chs[r] - 'A']--;
                r++;
            }

            if (!check(cnt, x)) {
                break;
            }

            cnt[chs[l] - 'A']++;
            res = Math.min(res, r - l);
            l++;
        }
        return res;
    }

    private boolean check(int[] cnt, int x) {
        return cnt['Q' - 'A'] <= x && cnt['W' - 'A'] <= x && cnt['E' - 'A'] <= x && cnt['R' - 'A'] <= x;
    }

    public static void main(String[] args) {
        String s = "QQWE";

        Main1234 main1234 = new Main1234();
        System.out.println(main1234.balancedString(s) == 1);
    }
}
