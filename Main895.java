import java.util.*;

/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main895.java
 * @CreateTime: 2022-11-30  09:30
 * @Version: 1.0
 */
public class Main895 {
    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        System.out.println(freqStack.pop() == 5);
        System.out.println(freqStack.pop() == 7);
        System.out.println(freqStack.pop() == 5);
        System.out.println(freqStack.pop() == 4);
    }
}

class FreqStack {
    private final Map<Integer, Integer> map;
    private final Map<Integer, Deque<Integer>> queueMap;
    private int max;

    public FreqStack() {
        this.map = new HashMap<>();
        this.queueMap = new HashMap<>();
        this.max = 0;
    }

    public void push(int val) {
        this.map.put(val, this.map.getOrDefault(val, 0) + 1);
        this.queueMap.computeIfAbsent(this.map.get(val), k -> new ArrayDeque<>());
        this.queueMap.get(this.map.get(val)).add(val);
        this.max = Math.max(this.max, this.map.get(val));
    }

    public int pop() {
        Integer res = this.queueMap.get(this.max).removeLast();
        this.map.put(res, this.map.get(res) - 1);
        if (this.queueMap.get(this.max).isEmpty()) {
            this.max --;
        }
        return res;
    }
}