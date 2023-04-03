/**
 * @ClassName: Main1053
 * @Auther: Chengxin Zhang
 * @Date: 2023/4/3 09:31
 * @Description:
 * @Version 1.0.0
 */
public class Main1053 {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                int j = n - 1;
                while (arr[j] >= arr[i] || arr[j] == arr[j - 1]) {
                    j --;
                }
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1};

        Main1053 main1053 = new Main1053();
        int[] res = main1053.prevPermOpt1(arr);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}
