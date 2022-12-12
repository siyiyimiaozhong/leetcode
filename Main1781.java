/**
 * @Author: siyiyimiaozhong
 * @Description: 1781. 所有子字符串美丽值之和
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1781.java
 * @CreateTime: 2022-12-12  09:16
 * @Version: 1.0
 */
public class Main1781 {

    public int beautySum(String s) {
        int res = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            int[] cnt = new int[26];
            int max = 0;
            for (int j = i; j < chs.length; j++) {
                cnt[chs[j] - 'a'] ++;

                max = Math.max(max, cnt[chs[j] - 'a']);
                int min = s.length();
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] <= 0) {
                        continue;
                    }

                    min = Math.min(min, cnt[k]);
                }
                res += max - min;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "aabcb";

        Main1781 main1781 = new Main1781();
        System.out.println(main1781.beautySum(str) == 5);
    }
}
