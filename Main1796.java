/**
 * @Author: siyiyimiaozhong
 * @Description: 1796. 字符串中第二大的数字
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1796.java
 * @CreateTime: 2022-12-03  19:28
 * @Version: 1.0
 */
public class Main1796 {
    public int secondHighest(String s) {
        char[] chars = s.toCharArray();
        boolean[] arr = new boolean[10];
        for (char ch : chars) {
            if (ch >= '0' && ch <= '9') {
                arr[ch - '0'] = true;
            }
        }
        boolean flag = false;
        for (int i = 9; i >= 0; i--) {
            if (arr[i]) {
                if (flag) {
                    return i;
                }
                flag = true;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "dfa12321afd";

        Main1796 main1796 = new Main1796();
        int res = main1796.secondHighest(str);
        System.out.println(res == 2);
    }
}
