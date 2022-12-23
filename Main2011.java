/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main2011.java
 * @CreateTime: 2022-12-23  09:18
 * @Version: 1.0
 */
public class Main2011 {

    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String operation : operations) {
            if (operation.startsWith("+") || operation.endsWith("+")) {
                res ++;
            } else {
                res --;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] operations = new String[]{"--X","X++","X++"};

        Main2011 main2011 = new Main2011();
        System.out.println(main2011.finalValueAfterOperations(operations) == 1);
    }
}
