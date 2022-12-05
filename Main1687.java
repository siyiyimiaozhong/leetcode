import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: siyiyimiaozhong
 * @Description: 1687. 从仓库到码头运输箱子
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1687.java
 * @CreateTime: 2022-12-05  09:27
 * @Version: 1.0
 */
public class Main1687 {
    public int boxDelivering1(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int len = boxes.length;
        int[] dp = new int[len + 1];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;
        for (int i = 1; i <= len; i++) {
            int sum = 0;
            for (int j = i; j > 0; j--) {
                sum += boxes[j - 1][1];
                if (i - j + 1 > maxBoxes || sum > maxWeight) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[j - 1] + dis(boxes, j, i));
            }
        }

        return dp[len];
    }

    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        int[] neg = new int[n + 1];
        long[] w = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            if (i > 1) {
                neg[i] = neg[i - 1] + (boxes[i - 2][0] != boxes[i - 1][0] ? 1 : 0);
            }
            w[i] = w[i - 1] + boxes[i - 1][1];
        }

        Deque<Integer> opt = new LinkedList<>();
        opt.offerLast(0);
        int f = 0;
        int[] g = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            while (i - opt.peekFirst() > maxBoxes || w[i] - w[opt.peekFirst()] > maxWeight) {
                opt.pollFirst();
            }

            f = g[opt.peekFirst()] + neg[i] + 2;

            if (i != n) {
                g[i] = f - neg[i + 1];
                while (!opt.isEmpty() && g[i] <= g[opt.peekLast()]) {
                    opt.pollLast();
                }
                opt.offerLast(i);
            }
        }

        return f;
    }

    private int dis(int[][] boxes, int j, int i) {
        int ans = 2;
        int tmp = boxes[j - 1][0];
        while (j++ < i) {
            if (tmp == boxes[j - 1][0]) {
                continue;
            }
            ans++;
            tmp = boxes[j - 1][0];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] boxes = {{1,2}, {3,3}, {3,1}, {3,1}, {2,4}};
        int portsCount = 3;
        int maxBoxes = 3;
        int maxWeight = 6;

        Main1687 main1687 = new Main1687();
        System.out.println(main1687.boxDelivering(boxes, portsCount, maxBoxes, maxWeight));
        System.out.println(main1687.boxDelivering(boxes, portsCount, maxBoxes, maxWeight) == 6);
    }
}
