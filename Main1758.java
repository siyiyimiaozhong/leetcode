/**
 * @Author: siyiyimiaozhong
 * @Description: 1758. 生成交替二进制字符串的最少操作数
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1758.java
 * @CreateTime: 2022-11-29  09:09
 * @Version: 1.0
 */
public class Main1758 {

    public int minOperations(String s) {
        int cnt = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == (i % 2) + '0') {
                cnt ++;
            }
        }
        return Math.min(cnt, s.length() - cnt);
    }

    public static void main(String[] args) {
        String s = "0100";

        Main1758 main1758 = new Main1758();
        System.out.println(main1758.minOperations(s));
    }
}
