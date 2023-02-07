import java.util.*;

/**
 * @Author: siyiyimiaozhong
 * @Description: 1604. 警告一小时内使用相同员工卡大于等于三次的人
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1604.java
 * @CreateTime: 2023-02-07  09:13
 * @Version: 1.0
 */
public class Main1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String key = keyName[i];
            map.computeIfAbsent(key, k -> new ArrayList<>());

            char[] chs = keyTime[i].toCharArray();
            int h = (chs[0] - '0') * 10 + (chs[1] - '0');
            int m = (chs[3] - '0') * 10 + (chs[4] - '0');
            map.get(key).add(h * 60 + m);
        }

        List<String> res = new ArrayList<>();
        map.forEach((key, value) -> {
            Collections.sort(value);
            for (int i = 2; i < value.size(); i++) {
                if (value.get(i) - value.get(i - 2) <= 60) {
                    res.add(key);
                    break;
                }
            }
        });
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        String[] keyName = new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
        String[] keyTime = new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};

        Main1604 main1604 = new Main1604();
        List<String> res = main1604.alertNames(keyName, keyTime);
        System.out.println(res.size() == 1 && res.get(0).equals("daniel"));
    }
}
