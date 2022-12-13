/**
 * @Author: siyiyimiaozhong
 * @Description: 1832. 判断句子是否为全字母句
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1832.java
 * @CreateTime: 2022-12-13  09:16
 * @Version: 1.0
 */
public class Main1832 {

    public boolean checkIfPangram(String sentence) {
        int cnt = 0;
        boolean[] arr = new boolean[26];
        char[] chs = sentence.toCharArray();
        for (char ch : chs) {
            if (!arr[ch - 'a']) {
                cnt ++;
            }
            arr[ch - 'a'] = true;
        }
        return cnt == 26;
    }

    public static void main(String[] args) {
        String s = "thequickbrownfoxjumpsoverthelazydog";

        Main1832 main1832 = new Main1832();
        System.out.println(main1832.checkIfPangram(s));
    }
}
