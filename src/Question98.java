/**
 * 98. 验证二叉搜索树
 */
public class Question98 {
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


    /*
    *  【错误解】仅判断：1.每个节点的左儿子小于它，右儿子大于它；2.左儿子递归满足，右儿子递归满足；
    * 没有判断左字数的所有值都要小于右子树，可能出现以下情况
    *                 7
    *                / \
    *               5   8
    *              / \
    *             4   9
    * 这并不是一颗二叉搜索树
    * */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (root.left != null) {
            if (!(root.left.val < root.val)) return false;
        }

        if (root.right != null) {
            if (!(root.right.val > root.val)) return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    /**
     * 【最优解】【官方题解】【递归遍历（深度优先搜索）】
     * 这启示我们设计一个递归函数helper(root, lower, upper)来递归判断，函数表示考虑以root为根的子树，
     * 判断子树中所有节点的值是否都在(l,r)的范围内（注意是开区间）。如果root节点的值val不在(l,r)的范围内说明不满足条件直接返回，
     * 否则我们要继续递归调用检查它的左右子树是否满足，如果都满足才说明这是一棵二叉搜索树。
     * 那么根据二叉搜索树的性质，在递归调用左子树时，我们需要把上界upper改为root.val，即调用helper(root.left, lower, root.val)，
     * 因为左子树里所有节点的值均小于它的根节点的值。同理递归调用右子树时，我们需要把下界lower改为root.val，
     * 即调用helper(root.right, root.val, upper)。
     * 时间复杂度：O(N)
     * 空间复杂度：O(N) 递归遍历需要栈空间。
     */
    public boolean isValidBST1(TreeNode root) {
        //return isSubTreeValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return isSubTreeValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isSubTreeValid(TreeNode root, long lower, long upper) {
        if (root == null) return true;

        if (root.val <= lower || root.val >= upper) {
            return false;
        }

        return isSubTreeValid(root.left, lower, root.val) && isSubTreeValid(root.right, root.val, upper);
    }
}
