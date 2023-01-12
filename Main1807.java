import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1807.java
 * @CreateTime: 2023-01-12  09:19
 * @Version: 1.0
 */
public class Main1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }
        char[] chs = s.toCharArray();
        int n = chs.length;
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            char ch = chs[i];
            if (ch == '(') {
                tmp = new StringBuilder();
                flag = true;
            } else if (ch == ')') {
                sb.append(map.getOrDefault(tmp.toString(), "?"));
                flag = false;
            } else {
                tmp.append(ch);
            }
            if (!flag && ch != ')') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "(name)is(age)yearsold";
        List<List<String>> knowledge = Arrays.asList(Arrays.asList("name", "bob"), Arrays.asList("age", "two"));

        Main1807 main1807 = new Main1807();
        System.out.println(main1807.evaluate(s, knowledge));
    }
}
