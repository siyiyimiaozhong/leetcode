import java.util.HashMap;
import java.util.Map;

/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1797.java
 * @CreateTime: 2023-02-09  23:52
 * @Version: 1.0
 */
public class Main1797 {
    class AuthenticationManager {

        private int timeToLive;
        private Map<String, Integer> map;

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
            this.map = new HashMap<>();
        }

        public void generate(String tokenId, int currentTime) {
            this.map.put(tokenId, currentTime + this.timeToLive);
        }

        public void renew(String tokenId, int currentTime) {
            if (this.map.getOrDefault(tokenId, 0) > currentTime) {
                this.map.put(tokenId, currentTime + this.timeToLive);
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            int res = 0;
            for (Integer time : this.map.values()) {
                if (time > currentTime) {
                    res++;
                }
            }
            return res;
        }
    }
}
