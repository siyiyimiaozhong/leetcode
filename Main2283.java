import java.util.HashMap;
import java.util.Map;

/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main2283.java
 * @CreateTime: 2023-01-11  09:27
 * @Version: 1.0
 */
public class Main2283 {
    public boolean digitCount(String num) {
        char[] chs = num.toCharArray();
        Map<Integer, Integer> set = new HashMap<>();
        int n = num.length();
        for (int i = 0; i < n; i++) {
            int x = chs[i] - '0';
            set.put(x, set.getOrDefault(x, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int v = chs[i] - '0';
            if (set.getOrDefault(i, 0) != v) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String num = "1210";

        Main2283 main2283 = new Main2283();
        System.out.println(main2283.digitCount(num));
    }
}
