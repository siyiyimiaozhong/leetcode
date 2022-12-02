import java.util.Arrays;

/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1769.java
 * @CreateTime: 2022-12-02  09:06
 * @Version: 1.0
 */
public class Main1769 {
    public int[] minOperations(String boxes) {
        char[] chars = boxes.toCharArray();
        int[] res = new int[boxes.length()];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                continue;
            }
            for (int j = 0; j < res.length; j++) {
                res[j] += Math.abs(j - i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "110";

        Main1769 main1769 = new Main1769();
        System.out.println(Arrays.toString(main1769.minOperations(str)));
    }
}
