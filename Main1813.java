/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1813.java
 * @CreateTime: 2023-01-16  12:32
 * @Version: 1.0
 */
public class Main1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] strArr1 = sentence1.split(" ");
        String[] strArr2 = sentence2.split(" ");
        int len1 = strArr1.length;
        int len2 = strArr2.length;

        int l = 0, r = 0;
        while (l < len1 && l < len2 && strArr1[l].equals(strArr2[l])) {
            l++;
        }
        while (r < len1 - l && r < len2 - l && strArr1[len1 - r - 1].equals(strArr2[len2 - r - 1])) {
            r++;
        }
        return l + r == Math.min(len1, len2);
    }

    public static void main(String[] args) {
        String sentence1 = "My name is Haley";
        String sentence2 = "My Haley";

        Main1813 main1813 = new Main1813();
        System.out.println(main1813.areSentencesSimilar(sentence1, sentence2));
    }
}
