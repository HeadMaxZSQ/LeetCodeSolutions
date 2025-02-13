/**
 * 112. 路径总和
 */
public class Question112 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 【最优解】【递归】
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //【注意】本题条件中val可能小于0，所以必须要遍历到所有叶子节点，不能中途剪枝。

        if (root == null) return false;

        //如果当前节点是叶子节点，则判断当前值是否等于targetSum即可
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
