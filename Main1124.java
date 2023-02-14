import java.util.Stack;

/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1124.java
 * @CreateTime: 2023-02-14  09:41
 * @Version: 1.0
 */
public class Main1124 {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        Stack<Integer> stack = new Stack<>();
        int[] sum = new int[n + 1];

        stack.push(0);
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            if (sum[stack.peek()] > sum[i]) {
                stack.push(i);
            }
        }

        int res = 0;
        for (int i = n; i > 0; i--) {
            while (!stack.isEmpty() && sum[stack.peek()] < sum[i]) {
                res = Math.max(res, i - stack.peek());
                stack.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] hours = new int[]{9, 9, 6, 0, 6, 6, 9};

        Main1124 main1124 = new Main1124();
        System.out.println(main1124.longestWPI(hours) == 3);
    }
}
