/**
 * @Author: siyiyimiaozhong
 * @Description: 2042. 检查句子中的数字是否递增
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main2042.java
 * @CreateTime: 2023-01-03  09:06
 * @Version: 1.0
 */
public class Main2042 {

    public boolean areNumbersAscending(String s) {
        String[] sArr = s.split(" ");
        int num = Integer.MIN_VALUE;
        for (String s1 : sArr) {
            char c = s1.charAt(0);
            if (c >= '0' && c <= '9') {
                int x = Integer.parseInt(s1);
                if (x <= num) {
                    return false;
                }
                num = x;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "hello world 5 x 5";

        Main2042 main2042 = new Main2042();
        System.out.println(main2042.areNumbersAscending(s) == false);
    }
}
