import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Main1039
 * @Auther: Chengxin Zhang
 * @Date: 2023/4/2 14:22
 * @Description: 1039. 多边形三角剖分的最低得分
 * @Version 1.0.0
 */
public class Main1039 {

    private int n;
    private int[] values;
    private Map<Integer, Integer> map = new HashMap<>();

    public int minScoreTriangulation(int[] values) {
        this.n = values.length;
        this.values = values;
        return fun(0, n - 1);
    }

    private int fun(int i, int j) {
        if (i + 2 > j) {
            return 0;
        }
        if (i + 2 == j) {
            return values[i] * values[i + 1] * values[j];
        }
        int key = i * n + j;
        if (!this.map.containsKey(key)) {
            int min = Integer.MAX_VALUE;
            for (int k = i + 1; k < j; k++) {
                min = Math.min(min, values[i] * values[k] * values[j] + fun(i, k) + fun(k, j));
            }
            this.map.put(key, min);
        }
        return this.map.get(key);
    }

    public static void main(String[] args) {
        int[] values = new int[]{3,7,4,5};

        Main1039 main1039 = new Main1039();
        System.out.println(main1039.minScoreTriangulation(values) == 144);
    }
}
