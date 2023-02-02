import java.util.*;

/**
 * @Author: siyiyimiaozhong
 * @Description: 1129. 颜色交替的最短路径
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1129.java
 * @CreateTime: 2023-02-02  09:13
 * @Version: 1.0
 */
public class Main1129 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[][] edge = new List[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                edge[i][j] = new ArrayList<>();
            }
        }

        for (int[] redEdge : redEdges) {
            edge[0][redEdge[0]].add(redEdge[1]);
        }
        for (int[] blueEdge : blueEdges) {
            edge[1][blueEdge[0]].add(blueEdge[1]);
        }

        int[][] dis = new int[2][n];
        Arrays.fill(dis[0], Integer.MAX_VALUE);
        Arrays.fill(dis[1], Integer.MAX_VALUE);
        dis[0][0] = dis[1][0] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        queue.add(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            for (Integer to : edge[1 - x][y]) {
                if (dis[1 - x][to] != Integer.MAX_VALUE) {
                    continue;
                }
                dis[1 - x][to] = dis[x][y] + 1;
                queue.add(new int[]{1 - x, to});
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = Math.min(dis[0][i], dis[1][i]);
            if (res[i] == Integer.MAX_VALUE) {
                res[i] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] redEdges = new int[][]{{0, 1}};
        int[][] blueEdges = new int[][]{{1, 2}};

        Main1129 main1129 = new Main1129();
        int[] res = main1129.shortestAlternatingPaths(n, redEdges, blueEdges);
        System.out.println(Arrays.equals(res, new int[]{0, 1, 2}));
    }
}
