import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Chengxin Zhang
 * @Description: 1487. 保证文件名唯一
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1487.java
 * @CreateTime: 2023-03-03  09:12
 * @Version: 1.0
 */
public class Main1487 {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        int n = names.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            if (map.containsKey(names[i])) {
                Integer cnt = map.get(names[i]);
                String s = names[i] + "(" + cnt + ")";
                while (map.containsKey(s)) {
                    cnt++;
                    s = names[i] + "(" + cnt + ")";
                }
                res[i] = s;
                map.put(names[i], cnt + 1);
                map.put(s, 1);
            } else {
                res[i] = names[i];
                map.put(names[i], 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] names = {"kaido","kaido(1)","kaido","kaido(1)","kaido(2)"};

        Main1487 main1487 = new Main1487();
        String[] folderNames = main1487.getFolderNames(names);
        for (String folderName : folderNames) {
            System.out.print(folderName + " ");
        }
    }
}
