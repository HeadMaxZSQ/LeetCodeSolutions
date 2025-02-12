import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 114. 二叉树展开为链表
 */
public class Question114 {

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
     * 【较优解】【递归前序遍历】递归进行前序遍历，并将节点存在list中，最后对list进行连接。
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    private ArrayList<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        if (root == null) return;

        preorderTraversal(root);

        int length = list.size();
        for (int i = 0; i < length - 1; i++) {
            TreeNode node = list.get(i);
            node.left = null;
            node.right = list.get(i + 1);
        }
    }

    private void preorderTraversal(TreeNode root) {
        if (root == null) return;
        list.add(root);
        if (root.left != null) {
            preorderTraversal(root.left);
        }
        if (root.right != null) {
            preorderTraversal(root.right);
        }
    }
}
