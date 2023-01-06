/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main2180.java
 * @CreateTime: 2023-01-06  12:22
 * @Version: 1.0
 */
public class Main2180 {
    public int countEven(int num) {
        int x = num / 10;
        int y = num % 10;
        int res = x * 5;
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        if ((sum & 1) == 1) {
            res += (y + 1) / 2;
        } else {
            res += y / 2 + 1;
        }
        return res - 1;
    }

    public static void main(String[] args) {
        int num = 4;

        Main2180 main2180 = new Main2180();
        System.out.println(main2180.countEven(num) == 2);
    }
}
