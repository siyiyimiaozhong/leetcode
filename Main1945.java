/**
 * @Author: siyiyimiaozhong
 * @Description: 1945. 字符串转化后的各位数字之和
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1945.java
 * @CreateTime: 2022-12-15  20:44
 * @Version: 1.0
 */
public class Main1945 {
    public int getLucky(String s, int k) {
        char[] chs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chs) {
            sb.append(ch - 'a' + 1);
        }
        String s1 = sb.toString();
        int sum = 0;
        for (int i = 1; i <= k; i++) {
            sum = 0;
            for (int j = 0; j < s1.length(); j++) {
                sum += s1.charAt(j) - '0';
            }
            s1 = Integer.toString(sum);
        }

        return sum;
    }


    public static void main(String[] args) {
        String s = "iiii";
        int k = 1;

        Main1945 main1945 = new Main1945();
        System.out.println(main1945.getLucky(s, k) == 36);
    }
}
