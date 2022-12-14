import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1697.java
 * @CreateTime: 2022-12-14  21:50
 * @Version: 1.0
 */
public class Main1697 {

    public int find(int[] pre, int x) {
        if (pre[x] == x) {
            return x;
        }
        return pre[x] = find(pre, pre[x]);
    }

    public void unit(int[] pre, int x, int y) {
        x = find(pre, x);
        y = find(pre, y);
        pre[x] = y;
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));

        Integer[] index = new Integer[queries.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, Comparator.comparingInt(a -> queries[a][2]));

        int[] pre = new int[n];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = i;
        }
        boolean[] ans = new boolean[queries.length];
        int i = 0;
        for (Integer integer : index) {
            while (i < edgeList.length && edgeList[i][2] < queries[integer][2]) {
                unit(pre, edgeList[i][0], edgeList[i][1]);
                i ++;
            }
            ans[integer] = find(pre, queries[integer][0]) == find(pre, queries[integer][1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edgeList = {{0, 1, 2}, {1, 2, 4}, {2, 0, 8}, {1, 0, 16}};
        int[][] queries = {{0, 1, 2}, {0, 2, 5}};

        Main1697 main1697 = new Main1697();
        System.out.println(Arrays.toString(main1697.distanceLimitedPathsExist(n, edgeList, queries)));
    }
}
