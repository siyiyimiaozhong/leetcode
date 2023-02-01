import java.util.HashMap;
import java.util.Map;

/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main2325.java
 * @CreateTime: 2023-02-01  09:11
 * @Version: 1.0
 */
public class Main2325 {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();

        char x = 'a';
        char[] chs = key.toCharArray();
        for (char ch : chs) {
            if (null == map.get(ch) && ch != ' ') {
                map.put(ch, x ++);
            }
        }

        StringBuilder sb = new StringBuilder();
        char[] messageChs = message.toCharArray();
        for (char messageCh : messageChs) {
            sb.append(map.getOrDefault(messageCh, messageCh));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";

        Main2325 main2325 = new Main2325();
        System.out.println(main2325.decodeMessage(key, message).equals("this is a secret"));
    }
}
