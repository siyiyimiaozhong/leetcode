/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1739.java
 * @CreateTime: 2022-12-25  12:49
 * @Version: 1.0
 */
public class Main1739 {

    public int minimumBoxes(int n) {
        int cur = 1, i = 1, j = 1;

        while (n > cur) {
            n -= cur;
            i++;
            cur += i;
        }
        cur = 1;
        while (n > cur) {
            n -= cur;
            j++;
            cur++;
        }
        return (i - 1) * i / 2 + j;
    }

    public static void main(String[] args) {
        int n = 3;

        Main1739 main1739 = new Main1739();
        System.out.println(main1739.minimumBoxes(n) == 3);
    }
}
