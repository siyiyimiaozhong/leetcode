/**
 * @ClassName: Main1017
 * @Auther: Chengxin Zhang
 * @Date: 2023/4/6 09:33
 * @Description: 1017. 负二进制转换
 * @Version 1.0.0
 */
public class Main1017 {

    public String baseNeg2(int n) {
        if (n == 0 || n == 1) {
            return String.valueOf(n);
        }

        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int x = n & 1;
            sb.append(x);
            n -= x;
            n /= -2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int n = 3;

        Main1017 main1017 = new Main1017();
        String res = main1017.baseNeg2(n);
        System.out.println("111".equals(res));
    }
}
