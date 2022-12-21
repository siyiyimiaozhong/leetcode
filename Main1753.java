/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1753.java
 * @CreateTime: 2022-12-21  19:09
 * @Version: 1.0
 */
public class Main1753 {
    public int maximumScore(int a, int b, int c) {
        int max = Math.max(Math.max(a, b), c);
        int sum = a + b + c;
        return Math.min(sum - max, sum / 2);
    }

    public static void main(String[] args) {
        int a = 2, b = 4, c= 6;

        Main1753 main1753 = new Main1753();
        System.out.println(main1753.maximumScore(a, b, c) == 6);
    }
}
