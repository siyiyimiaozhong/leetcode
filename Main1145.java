/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1145.java
 * @CreateTime: 2023-02-03  09:12
 * @Version: 1.0
 */
public class Main1145 {
    private TreeNode xNode;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        find(root, x);
        int left = getNodeNumber(this.xNode.left);
        if (left > n - left) {
            return true;
        }
        int right = getNodeNumber(this.xNode.right);
        if (right > n- right) {
            return true;
        }
        return n - left - right - 1 > left + right + 1;
    }

    private int getNodeNumber(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return 1 + getNodeNumber(root.left) + getNodeNumber(root.right);
    }

    private void find(TreeNode root, int x) {
        if (null != this.xNode || null == root) {
            return;
        }
        if (root.val == x) {
            this.xNode = root;
            return;
        }
        find(root.left, x);
        find(root.right, x);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
