/**
 * @ClassName: Main831
 * @Auther: Chengxin Zhang
 * @Date: 2023/4/1 13:59
 * @Description: 831. 隐藏个人信息
 * @Version 1.0.0
 */
public class Main831 {
    public String maskPII(String s) {
        String[] arr = new String[]{"***-***-", "+*-***-***-", "+**-***-***-", "+***-***-***-"};

        String[] split = s.split("@");
        if (split.length == 2) {
            char[] chs = split[0].toCharArray();
            return (chs[0] + "*****" + chs[chs.length - 1] + "@" + split[1]).toLowerCase();
        }
        s = s.replaceAll("[^0-9]", "");
        return arr[s.length() - 10] + s.substring(s.length() - 4);
    }

    public static void main(String[] args) {
        String s = "LeetCode@LeetCode.com";

        Main831 main831 = new Main831();
        String res = main831.maskPII(s);
        System.out.println("l*****e@leetcode.com".equals(res));
    }
}
