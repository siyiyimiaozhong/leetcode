/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1971.java
 * @CreateTime: 2022-12-19  19:24
 * @Version: 1.0
 */
public class Main1971 {
    private int[] pre;

    private int find(int x) {
        if (x == pre[x]) {
            return x;
        }
        return pre[x] = find(pre[x]);
    }

    private void unit(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            pre[x] = y;
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        this.pre = new int[n];
        for (int i = 0; i < n; i++) {
            this.pre[i] = i;
        }
        for (int[] edge : edges) {
            unit(edge[0], edge[1]);
        }
        return find(source) == find(destination);
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = new int[][] {{0, 1}, {1,2},{2,0}};
        int source = 0;
        int destination = 2;

        Main1971 main1971 = new Main1971();
        System.out.println(main1971.validPath(n, edges, source, destination) == true);
    }
}
