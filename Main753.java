import java.util.HashSet;
import java.util.Set;

/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main753.java
 * @CreateTime: 2023-01-10  09:25
 * @Version: 1.0
 */
public class Main753 {
    private Set<Integer> set = new HashSet<>();
    private StringBuilder ans = new StringBuilder();
    private int highest;
    private int k;

    public String crackSafe(int n, int k) {
        highest = (int) Math.pow(10, n - 1);
        this.k = k;
        dfs(0);
        for (int i = 1; i < n; i++) {
            ans.append('0');
        }
        return ans.toString();
    }

    public void dfs(int node) {
        for (int x = 0; x < k; ++x) {
            int nei = node * 10 + x;
            if (!set.contains(nei)) {
                set.add(nei);
                dfs(nei % highest);
                ans.append(x);
            }
        }
    }

    public static void main(String[] args) {
        int n = 2;
        int k = 2;

        Main753 main753 = new Main753();
        System.out.println(main753.crackSafe(n, k));
    }
}
