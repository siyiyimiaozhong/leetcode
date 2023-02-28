import java.util.*;

/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main2363.java
 * @CreateTime: 2023-02-28  09:18
 * @Version: 1.0
 */
public class Main2363 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] ints : items1) {
            map.put(ints[0], map.getOrDefault(ints[0], 0) + ints[1]);
        }
        for (int[] ints : items2) {
            map.put(ints[0], map.getOrDefault(ints[0], 0) + ints[1]);
        }
        List<List<Integer>> res = new LinkedList<>();
        map.forEach((key, value) -> {
            List<Integer> list = new LinkedList<>();
            list.add(key);
            list.add(value);
            res.add(list);
        });
        Collections.sort(res, Comparator.comparingInt(a -> a.get(0)));
        return res;
    }

    public static void main(String[] args) {
        int[][] items1 = {{1, 1}, {4, 5}, {3, 8}};
        int[][] items2 = {{3, 1}, {1, 5}};

        Main2363 main2363 = new Main2363();
        System.out.println(main2363.mergeSimilarItems(items1, items2));
    }
}
