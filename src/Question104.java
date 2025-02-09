public class Question104 {

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
     * 【深度优先搜索】【自己想的】【最优解】某个节点左子树和右子树的最大深度分别为l和r，则当前节点的最大深度为max(l, r) + 1。
     * 时间复杂度：O(N) 每个节点只被遍历一次。
     * 空间复杂度：O(height)，其中height表示二叉树的高度。递归函数需要栈空间，而栈空间取决于递归的深度，因此空间复杂度等价于二叉树的高度。
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    /**
     * 【广度优先搜索】【题解看的】一层层遍历（运行结果看性能不如深度优先搜索）
     * 时间复杂度：O(N)
     * 空间复杂度：取决于队列存储的元素，最坏情况下为O(N)
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}