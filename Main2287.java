import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main2287.java
 * @CreateTime: 2023-01-13  13:57
 * @Version: 1.0
 */
public class Main2287 {
    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }
        chs = target.toCharArray();
        for (char ch : chs) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        AtomicInteger res = new AtomicInteger(Integer.MAX_VALUE);
        targetMap.forEach((key, value) -> {
            Integer sCount = sMap.getOrDefault(key, 0);
            res.set(Math.min(res.get(), sCount / value));
        });
        return res.get();
    }

    public static void main(String[] args) {
        String s = "ilovecodingonleetcode";
        String target = "code";

        Main2287 main2287 = new Main2287();
        System.out.println(main2287.rearrangeCharacters(s, target) == 2);
    }
}
