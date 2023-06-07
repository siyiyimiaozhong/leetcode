import java.util.Arrays;

/**
 * @ClassName: Main2611
 * @Auther: Chengxin Zhang
 * @Date: 2023/6/7 09:05
 * @Description: 2611. 老鼠和奶酪
 * @Version 1.0.0
 */
public class Main2611 {
    public static void main(String[] args) {
        int[] reward1 = new int[]{1,1,3,4};
        int[] reward2 = new int[]{4,4,1,1};
        int k = 2;

        Main2611 main2611 = new Main2611();
        int res = main2611.miceAndCheese(reward1, reward2, k);
        System.out.println(res);
        System.out.println(res == 15);
    }

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            sum += reward2[i];
            arr[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < k && i < n; i++) {
            sum += arr[n - i - 1];
        }
        return sum;
    }
}
