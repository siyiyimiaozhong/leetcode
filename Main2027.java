/**
 * @Author: siyiyimiaozhong
 * @Description: 2027. 转换字符串的最少操作次数
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main2027.java
 * @CreateTime: 2022-12-27  09:17
 * @Version: 1.0
 */
public class Main2027 {
    public int minimumMoves(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (chs[i] == 'X') {
                cnt ++;
                i += 2;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String s = "XXOX";

        Main2027 main2027 = new Main2027();
        System.out.println(main2027.minimumMoves(s) == 2);
    }
}
