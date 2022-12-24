/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1754.java
 * @CreateTime: 2022-12-24  12:51
 * @Version: 1.0
 */
public class Main1754 {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int len1 = word1.length(), len2 = word2.length();
        char[] chs1 = word1.toCharArray(), chs2 = word2.toCharArray();
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (chs1[i] > chs2[j]) {
                sb.append(chs1[i ++]);
            } else if (chs1[i] < chs2[j]) {
                sb.append(chs2[j ++]);
            } else {
                int m = i + 1, n = j + 1;
                while (m < len1 && n < len2 && chs1[m] == chs2[n]) {
                    m++ ;
                    n ++;
                }
                int i2 = Math.min(m, len1 - 1);
                int j2 = Math.min(n, len2 - 1);
                if (chs1[i2] < chs2[j2] || m == len1) {
                    sb.append(chs2[j ++]);
                } else {
                    sb.append(chs1[i ++]);
                }
            }
        }
        if (i < len1) {
            sb.append(word1.substring(i));
        }
        if (j < len2) {
            sb.append(word2.substring(j));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String word1 = "cabaa";
        String word2 = "bcaaa";

        Main1754 main1754 = new Main1754();
        System.out.println(main1754.largestMerge(word1, word2).equals("cbcabaaaaa"));
    }
}
