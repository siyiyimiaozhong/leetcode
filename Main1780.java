/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1780.java
 * @CreateTime: 2022-12-09  09:24
 * @Version: 1.0
 */
public class Main1780 {

    public boolean checkPowersOfThree(int n) {
        while(n != 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 12;

        Main1780 main1780 = new Main1780();
        System.out.println(main1780.checkPowersOfThree(n));
    }
}
