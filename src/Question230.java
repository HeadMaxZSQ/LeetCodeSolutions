/**
 * 230. 二叉搜索树中第 K 小的元素
 */
public class Question230 {

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
     * 【最优解】【自己想的】搜索二叉树中序遍历得到的结果是递增序列，所以只要找到中序遍历的第k个元素即可
     * 递归进行中序遍历，寻找第k个元素
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    private int currentIndex = 1;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;

        if (root.left != null) {
            int leftSubTreeAns = kthSmallest(root.left, k);
            if (leftSubTreeAns != -1) return leftSubTreeAns;
        }

        if (k == currentIndex) {
            return root.val;
        }
        currentIndex++;

        if (root.right != null) {
            int rightSubTreeAns = kthSmallest(root.right, k);
            if (rightSubTreeAns != -1) return rightSubTreeAns;
        }

        return -1;
    }
}
