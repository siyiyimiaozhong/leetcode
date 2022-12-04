/**
 * @Author: siyiyimiaozhong
 * @Description: 1774. 最接近目标价格的甜点成本
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1774.java
 * @CreateTime: 2022-12-04  14:31
 * @Version: 1.0
 */
public class Main1774 {

    private int res;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        this.res = baseCosts[0];
        for (int baseCost : baseCosts) {
            dfs(0, toppingCosts, target, baseCost);
        }

        return this.res;
    }

    private void dfs(int idx, int[] toppingCosts, int target, int price) {
        if (Math.abs(this.res - target) < price - target) {
            return;
        } else if (Math.abs(this.res - target) > Math.abs(price - target)) {
            this.res = price;
        } else if (Math.abs(this.res - target) == Math.abs(price - target)) {
            this.res = Math.min(this.res, price);
        }

        if (idx == toppingCosts.length) {
            return;
        }

        dfs(idx + 1, toppingCosts, target, price);
        dfs(idx + 1, toppingCosts, target, price + toppingCosts[idx]);
        dfs(idx + 1, toppingCosts, target, price + 2 * toppingCosts[idx]);
    }

    public static void main(String[] args) {
        int[] baseCosts = new int[]{1, 7};
        int[] toppingCosts = new int[]{3, 4};
        int target = 10;

        Main1774 main1774 = new Main1774();
        System.out.println(main1774.closestCost(baseCosts, toppingCosts, target) == 10);
    }
}
