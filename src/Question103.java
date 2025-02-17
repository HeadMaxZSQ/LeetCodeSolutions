import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 */
public class Question103 {
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
     * 【最优解】【层序遍历（广度优先搜索）】
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (flag) {
                    level.add(node.val);// or level.offerLast(node.val)
                } else {
                    level.addFirst(node.val);// or level.offerFirst(node.val)
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            flag = !flag;
            result.add(level);
        }

        return result;
    }
}
