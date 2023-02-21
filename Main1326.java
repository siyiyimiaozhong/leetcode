/**
 * @Author: siyiyimiaozhong
 * @Description: 1326. 灌溉花园的最少水龙头数目
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1326.java
 * @CreateTime: 2023-02-21  09:27
 * @Version: 1.0
 */
public class Main1326 {

    public int minTaps(int n, int[] ranges) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i <= n; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            arr[start] = Math.max(arr[start], end);
        }

        int res = 0, end = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, arr[i]);
            if (end == i) {
                return -1;
            }
            if (i == cur) {
                res ++;
                cur = end;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] ranges = new int[]{3,4,1,1,0,0};

        Main1326 main1326 = new Main1326();
        System.out.println(main1326.minTaps(n, ranges) == 1);
    }
}
