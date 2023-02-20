import java.util.HashMap;
import java.util.Map;

/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main2347.java
 * @CreateTime: 2023-02-20  09:28
 * @Version: 1.0
 */
public class Main2347 {
    public String bestHand(int[] ranks, char[] suits) {
        char ch = suits[0];
        boolean flag = false;
        for (char suit : suits) {
            if (ch != suit) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return "Flush";
        }
        Map<Integer, Integer> map = new HashMap<>();

        int x = 0;
        for (int rank : ranks) {
            int cnt = map.getOrDefault(rank, 0) + 1;
            map.put(rank, cnt);
            x = Math.max(x, cnt);
        }
        String res;
        if (x >= 3) {
            res = "Three of a Kind";
        } else if (x == 2) {
            res = "Pair";
        } else {
            res = "High Card";
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ranks = new int[]{13, 2, 3, 1, 9};
        char[] suits = new char[]{'a', 'a', 'a', 'a', 'a'};

        Main2347 main2347 = new Main2347();
        System.out.println("Flush".equals(main2347.bestHand(ranks, suits)));
    }
}
