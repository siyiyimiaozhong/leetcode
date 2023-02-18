import java.util.LinkedList;
import java.util.List;

/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1237.java
 * @CreateTime: 2023-02-18  09:32
 * @Version: 1.0
 */
public class Main1237 {

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new LinkedList<>();
        for (int x = 1; x <= 1000; x++) {
            for (int y = 1; y <= 1000; y++) {
                if (customfunction.f(x, y) == z) {
                    List<Integer> pair = new LinkedList<>();
                    pair.add(x);
                    pair.add(y);
                    res.add(pair);
                }
            }
        }
        return res;
    }

    interface CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y);
    }
}
