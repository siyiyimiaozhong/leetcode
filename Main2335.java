/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main2335.java
 * @CreateTime: 2023-02-11  13:18
 * @Version: 1.0
 */
public class Main2335 {
    public int fillCups(int[] amount) {
        int max = Math.max(amount[0], Math.max(amount[1], amount[2]));
        int sum = amount[0] + amount[1] + amount[2];

        if (sum - max <= max) {
            return max;
        }
        return (sum + 1) / 2;
    }

    public static void main(String[] args) {
        int[] amount = new int[]{1, 4, 2};

        Main2335 main2335 = new Main2335();
        System.out.println(main2335.fillCups(amount) == 4);
    }
}
