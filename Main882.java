import java.util.*;

/**
 *@Author: siyiyimiaozhong
 *@Description: 882. 细分图中的可到达节点
 *@Project: leetcode
 *@Package: PACKAGE_NAME
 *@ClassName: Main828.java
 *@CreateTime: 2022-11-26  23:39
 *@Version: 1.0
 */
public class Main882 {

    private final long inf =  (long)1e9 + 1;

    public class Tuple<T, E> {
        public T first;
        public E second;

        public Tuple(T first, E second){
            this.first = first;
            this.second = second;
        }
    }

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        long[][] map = new long[n][n];
        for (int i = 0; i < map.length; i++) {
            for (int j = i + 1; j < map[i].length; j++) {
                map[i][j] = inf;
                map[j][i] = inf;
            }
        }
        boolean[] vis = new boolean[n];
        long[] dis = new long[n];
        Arrays.fill(dis, inf);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cnt = edge[2];
            map[u][v] = cnt + 1;
            map[v][u] = cnt + 1;
        }

        Queue<Tuple<Long, Integer>> queue = new PriorityQueue<>((a, b) -> a.first > b.first ? 1 : -1);
        queue.add(new Tuple<>(0L ,0));
        dis[0] = 0;

        while(!queue.isEmpty()) {
            Tuple<Long, Integer> node = queue.poll();
            Integer x = node.second;

            if (vis[x]) {
                continue;
            }
            vis[x] = true;
            for (int i = 0; i < n; i++) {
                if (i != x && dis[i] > dis[x] + map[x][i]) {
                    dis[i] = dis[x] + map[x][i];
                    queue.add(new Tuple<>(dis[i], i));
                }
            }
        }

        int ans = 0;
        for (long di : dis) {
            if (di <= maxMoves) {
                ans ++;
            }
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cnt = edge[2];
            long a = Math.max(maxMoves - dis[u], 0L);
            long b = Math.max(maxMoves - dis[v], 0L);
            ans += Math.min(a+b, cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 10}, {0, 2, 1}, {1, 2, 2}};
        int maxMoves = 6;
        int n = 3;
        Main882 main882 = new Main882();
        int res = main882.reachableNodes(arr, maxMoves, n);
        System.out.println(res);
    }
}
