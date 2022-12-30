import java.util.TreeSet;

/**
 * @Author: siyiyimiaozhong
 * @Description: 855. 考场就座
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main855.java
 * @CreateTime: 2022-12-30  10:59
 * @Version: 1.0
 */
public class Main855 {
    class ExamRoom {
        private TreeSet<Integer> set;
        private int n;

        public ExamRoom(int n) {
            this.n = n;
            this.set = new TreeSet<>();
        }

        public int seat() {
            if (this.set.isEmpty()) {
                this.set.add(0);
                return 0;
            }
            int pre = this.set.first(), num = this.set.first(), idx = 0;
            for (int x : this.set) {
                if (num < (x - pre) / 2) {
                    num = (x - pre) / 2;
                    idx = (x + pre) / 2;
                }
                pre = x;
            }
            int x = n - 1 - set.last();
            if (num < x) {
                num = x;
                idx = n - 1;
            }
            this.set.add(idx);
            return idx;
        }

        public void leave(int p) {
            this.set.remove(p);
        }
    }
}
