import java.util.ArrayList;
import java.util.List;

/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1238.java
 * @CreateTime: 2023-02-23  09:27
 * @Version: 1.0
 */
public class Main1238 {

    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> res = new ArrayList<>();
        res.add(start);
        for (int i = 0; i < n; i++) {
            int size = res.size();
            for (int j = size - 1; j >= 0; j--) {
                res.add(((res.get(j) ^ start) | ((1 << i))) ^ start);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 2, start = 3;

        Main1238 main1238 = new Main1238();
        System.out.println(main1238.circularPermutation(n, start));
    }
}
