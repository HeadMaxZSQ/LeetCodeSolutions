import java.util.LinkedList;

public class Question226 {
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
     * 【深度优先搜索】【自己想的】
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)递归需要栈空间。使用的空间由递归栈的深度决定，它等于当前节点在二叉树中的高度。
     * 在平均情况下，二叉树的高度与节点个数为对数关系，即 O(logN)。而在最坏情况下，树形成链状，空间复杂度为 O(N)。
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        //交换左右子树的位置
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        //分别对左右子树进行反转
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 【广度优先搜索】
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return root;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            //交换当前节点的左右子树
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            //如果左子节点不为空，则加入队列等待处理
            if (node.left != null) {
                queue.offer(node.left);
            }
            //如果右子节点不为空，则加入队列等待处理
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return root;
    }
}