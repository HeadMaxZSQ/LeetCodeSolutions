/**
 * 129. 求根节点到叶节点数字之和
 */
public class Question129 {
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
     * 【最优解】【自己想的】【深度优先搜索（递归）】核心思想是：当前节点的和 = 父节点的和 * 10 + 当前节点val
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    int result = 0;
    public int sumNumbers(TreeNode root) {
        sumNode(root, 0);
        return result;
    }

    private void sumNode(TreeNode node, int parentSum) {
        if (node == null) return;

        int currentSum = parentSum * 10 + node.val;

        if (node.left == null && node.right == null) {
            result += currentSum;
            return;
        }

        if (node.left != null) {
            sumNode(node.left, currentSum);
        }
        if (node.right != null) {
            sumNode(node.right, currentSum);
        }
    }

    /**
     * 【最优解】【题解看的】根自己写的思路一样，只是更简洁的递归写法
     */
    public int sumNumbers2(TreeNode root) {
        return sumNode2(root, 0);
    }

    private int sumNode2(TreeNode node, int parentSum) {
        if (node == null) return 0;

        int currentSum = parentSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return currentSum;
        } else {
            return sumNode2(node.left, currentSum) + sumNode2(node.right, currentSum);
        }
    }
}
