/**
 * @Author: Chengxin Zhang
 * @Description: 面试题 05.02. 二进制数转字符串
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: MainM0502.java
 * @CreateTime: 2023-03-02  09:26
 * @Version: 1.0
 */
public class MainM0502 {

    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        int cnt = 0;
        while (cnt < 32 && num != 0) {
            num *= 2;
            int x = (int) num;
            sb.append(x);
            num -= x;
            cnt++;
        }
        return cnt == 32 ? "ERROR" : sb.toString();
    }

    public static void main(String[] args) {
        double num = 0.625;

        MainM0502 mainM0502 = new MainM0502();
        System.out.println(mainM0502.printBin(num).equals("0.101"));
    }
}
