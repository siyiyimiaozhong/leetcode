import java.util.HashSet;
import java.util.Set;

/**
 * @Author: siyiyimiaozhong
 * @Description: 1805. 字符串中不同整数的数目
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1805.java
 * @CreateTime: 2022-12-06  09:12
 * @Version: 1.0
 */
public class Main1805 {

    public int numDifferentIntegers(String word) {
        char[] chars = word.toCharArray();
        Set<String> set = new HashSet<>();
        int n = word.length(), p1 = 0, p2;
        while (true) {
            while (p1 < n && !Character.isDigit(chars[p1])) {
                p1++;
            }
            if (p1 == n) {
                break;
            }
            p2 = p1;
            while (p2 < n && Character.isDigit(chars[p2])) {
                p2++;
            }
            while (p2 - p1 > 1 && chars[p1] == '0') {
                p1++;
            }
            set.add(word.substring(p1, p2));
            p1 = p2;
        }
        return set.size();
    }

    public static void main(String[] args) {
        String str = "a1b01c001";

        Main1805 main1805 = new Main1805();
        System.out.println(main1805.numDifferentIntegers(str) == 1);
    }
}
