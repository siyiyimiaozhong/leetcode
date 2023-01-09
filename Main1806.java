/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1806.java
 * @CreateTime: 2023-01-09  09:18
 * @Version: 1.0
 */
public class Main1806 {
    public int reinitializePermutation(int n) {
        int[] arr;
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        int res = 0;
        while (true) {
            boolean flag = false;
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                if ((i & 1) == 1) {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                } else {
                    arr[i] = perm[i / 2];
                }
                if (!flag && arr[i] != i) {
                    flag = true;
                }
            }
            res ++;
            if (!flag) {
                break;
            }
            perm = arr;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4;

        Main1806 main1806 = new Main1806();
        System.out.println(main1806.reinitializePermutation(n) == 2);
    }
}
