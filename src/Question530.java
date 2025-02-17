/**
 * 530. 二叉搜索树的最小绝对差
 */
public class Question530 {
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

    int preValue = Integer.MIN_VALUE;
    int result = Integer.MAX_VALUE;

    /**
     * 【最优解】【题解看的】【中序遍历】【搜索二叉树中序遍历结果为一个递增数组】
     * 题解中做了一点优化，不需要将所有遍历结果都记录，只要记录前一个元素的值用于计算差即可。
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public int getMinimumDifference(TreeNode root) {
        middleOrder(root);
        return result;
    }

    //中序遍历，每遍历到一个元素时计算它与上一个元素值的差
    private void middleOrder(TreeNode root) {
        if (root == null) return;

        middleOrder(root.left);

        //【注意】这里的判断条件必不可少，因为需要判断当前元素是否是遍历到的第一个元素，第一个元素不用计算差值
        if (preValue != Integer.MIN_VALUE) result = Math.min(Math.abs(root.val - preValue), result);
        preValue = root.val;

        middleOrder(root.right);
    }
}
