import java.util.LinkedList;

/**
 * 100. 相同的树
 */
public class Question100 {

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
     * 【深度优先搜索】【题解看的】【最优解】先对两个节点判空，两个都为空则相同，一个为空则不同，两个都不为空就比较当前节点值相等并且左右子树分别相等。
     * 时间复杂度：O(min(m, n))
     * 空间复杂度：O(min(m, n))
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null) {
            return false;
        } else if (q == null) {
            return false;
        } else {
            return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    /**
     * 【广度优先搜索】【题解看的】
     */
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> queue2 = new LinkedList<TreeNode>();

        queue1.offer(p);
        queue2.offer(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            if (node1.val != node2.val) {
                return false;
            }

            // if ((node1.left == null && node2.left != null) || (node1.left != null && node2.left == null) 
            //     || (node1.right == null && node2.right != null) || (node1.right != null && node2.right == null)) {
            //     return false;
            // }
            //【注意】使用亦或运算符^来简化判断逻辑
            if (((node1.left == null) ^ (node2.left == null)) || ((node1.right == null) ^ (node2.right == null))) {
                return false;
            }

            if (node1.left != null) {
                queue1.offer(node1.left);
                queue2.offer(node2.left);
            }
            if (node1.right != null) {
                queue1.offer(node1.right);
                queue2.offer(node2.right);
            }
        }

        return (queue1.isEmpty() && queue2.isEmpty());
    }
}