import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: siyiyimiaozhong
 * @Description: 1233. 删除子文件夹
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1233.java
 * @CreateTime: 2023-02-08  09:25
 * @Version: 1.0
 */
public class Main1233 {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);

        List<String> res = new LinkedList<>();
        res.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String str = res.get(res.size() - 1);
            int pre = str.length();
            if (!(pre < folder[i].length() && str.equals(folder[i].substring(0, pre)) && folder[i].charAt(pre) == '/')) {
                res.add(folder[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] folder = new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};

        Main1233 main1233 = new Main1233();
        System.out.println(main1233.removeSubfolders(folder));
    }
}
