/**
 * @Author: Chengxin Zhang
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1653.java
 * @CreateTime: 2023-03-06  09:32
 * @Version: 1.0
 */
public class Main1653 {
    public int minimumDeletions(String s) {
        char[] chs = s.toCharArray();
        int a = 0, b = 0;
        for (char ch : chs) {
            if (ch == 'a') {
                a++;
            }
        }

        int res = a;
        for (char ch : chs) {
            if (ch == 'a') {
                a--;
            } else {
                b++;
            }
            res = Math.min(res, a + b);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aababbab";

        Main1653 main1653 = new Main1653();
        System.out.println(main1653.minimumDeletions(s) == 2);
    }
}
