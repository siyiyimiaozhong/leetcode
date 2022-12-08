/**
 * @Author: siyiyimiaozhong
 * @Description: 1812. 判断国际象棋棋盘中一个格子的颜色
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1812.java
 * @CreateTime: 2022-12-08  09:23
 * @Version: 1.0
 */
public class Main1812 {

    public boolean squareIsWhite(String coordinates) {
        char[] chars = coordinates.toCharArray();
        return ((chars[0] - 'a' + chars[1] - '0') & 1) != 1;
    }

    public static void main(String[] args) {
        String str = "a1";

        Main1812 main1812 = new Main1812();
        System.out.println(!main1812.squareIsWhite(str));
    }
}
