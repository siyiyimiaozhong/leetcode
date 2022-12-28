/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1750.java
 * @CreateTime: 2022-12-28  09:08
 * @Version: 1.0
 */
public class Main1750 {

    public int minimumLength(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        int num = 0;
        int i = 0, j = n - 1;
        while (i < j && chs[i] == chs[j]) {
            char ch = chs[i];
            while (i <= j && chs[i] == ch) {
                i ++;
            }
            while (i <= j && chs[j] == ch) {
                j --;
            }
        }
        return j - i + 1;
    }

    public static void main(String[] args) {
        String s = "aabccabba";

        Main1750 main1750 = new Main1750();
        System.out.println(main1750.minimumLength(s) == 3);
    }
}
