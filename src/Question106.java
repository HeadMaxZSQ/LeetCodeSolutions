import java.util.HashMap;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class Question106 {

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
     * 【最优解】【递归（深度优先搜索）】参照105题，一样的思路。自己想的，比题解的清晰。
     * 中序遍历：[ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
     * 后续遍历：[ [左子树的前序遍历结果], [右子树的前序遍历结果], 根节点]
     * 时间复杂度：O(n)，其中 n 是树中的节点个数。
     * 空间复杂度：O(n)。我们需要使用 O(n) 的空间存储哈希表，以及 O(h)（其中 h 是树的高度）的空间表示递归时栈空间。这里 h<n，所以总空间复杂度为 O(n)。
     */
    private HashMap<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        return myBuildTree(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] inorder, int[] postorder, int inorder_left, int inorder_right, int postorder_left, int postorder_right) {
        //先写推出条件
        if (postorder_left > postorder_right) {
            return null;
        }

        //找到后续遍历的根节点索引
        int postorder_root = postorder_right;
        //找到中序遍历的根节点索引
        int inorder_root = inorderMap.get(postorder[postorder_root]);

        //计算左子树元素个数(注意用闭区间)
        int size_left_sub_tree = inorder_root - inorder_left;

        //创建当前根节点
        TreeNode root = new TreeNode(postorder[postorder_root]);
        //递归计算左子树，并连接（注意用闭区间）
        root.left = myBuildTree(inorder, postorder,
                inorder_left, inorder_root - 1,
                postorder_left, postorder_left - 1 + size_left_sub_tree);
        //递归计算右子树，并连接（注意用闭区间）
        root.right = myBuildTree(inorder, postorder,
                inorder_root + 1, inorder_right,
                postorder_left + size_left_sub_tree, postorder_root - 1);
        return root;
    }
}
