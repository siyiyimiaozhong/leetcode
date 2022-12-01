/**
 * @Author: siyiyimiaozhong
 * @Description: 1779. 找到最近的有相同 X 或 Y 坐标的点
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1779.java
 * @CreateTime: 2022-12-01  09:00
 * @Version: 1.0
 */
public class Main1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int idx = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] == x || point[1] == y) {
                int tmp = Math.abs(point[0] - x) + Math.abs(point[1] - y);
                if (tmp < min) {
                    idx = i;
                    min = tmp;
                }
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        //x = 3, y = 4, points = [[1,2],[3,1],[2,4],[2,3],[4,4]]
        int x = 3, y = 4;
        int[][] arr = new int[][]{{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}};

        Main1779 main1779 = new Main1779();
        System.out.println(main1779.nearestValidPoint(x, y, arr));
    }
}
