import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: Main1637
 * @Auther: Chengxin Zhang
 * @Date: 2023/3/30 09:14
 * @Description: 1637. 两点之间不包含任何点的最宽垂直区域
 * @Version 1.0.0
 */
public class Main1637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int res = 0;
        int n = points.length;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, points[i][0] - points[i - 1][0]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{8,7},{9,9},{7,4},{9,7}};

        Main1637 main1637 = new Main1637();
        System.out.println(main1637.maxWidthOfVerticalArea(points) == 1);
    }
}
