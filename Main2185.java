/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main2185.java
 * @CreateTime: 2023-01-08  16:16
 * @Version: 1.0
 */
public class Main2185 {

    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = new String[] {"pay","attention","practice","attend"};
        String pref = "at";

        Main2185 main2185 = new Main2185();
        System.out.println(main2185.prefixCount(words, pref) == 2);
    }
}
