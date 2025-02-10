import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * （注意：题目条件中写明了无重复元素，不然这题可能解不唯一）
 */
public class Question105 {
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
     * 【最优解】【递归（深度优先搜索）】
     * 对于任意一颗树而言，前序遍历的形式总是：[ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]，即根节点总是前序遍历中的第一个节点。
     * 而中序遍历的形式总是：[ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]。
     * 只要我们在中序遍历中定位到根节点，那么我们就可以分别知道左子树和右子树中的节点数目。
     * 由于同一颗子树的前序遍历和中序遍历的长度显然是相同的，因此我们就可以对应到前序遍历的结果中，对上述形式中的所有左右括号进行定位。
     *
     * 时间复杂度：O(n)，其中 n 是树中的节点个数。
     * 空间复杂度：O(n)，除去返回的答案需要的 O(n) 空间之外，我们还需要使用 O(n) 的空间存储哈希映射，以及 O(h)（其中 h 是树的高度）的空间表示递归时栈空间。这里 h<n，所以总空间复杂度为 O(n)。
     */
    private Map<Integer, Integer> hashMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int num = inorder.length;
        for (int i = 0; i < num; i++) {
            hashMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, num - 1, 0, num - 1);
    }

    //注意该方法参数以及所有内部区间运算均为闭区间
    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {

        //退出条件：前序遍历的左指针大于右指针（也可以是中序遍历的左指针大于右指针）
        if (preorder_left > preorder_right) {
            return null;
        }

        //当前前序遍历区间的第一个节点就是当前根节点，记录下标
        int preorder_root = preorder_left;
        //从HashMap中找出根节点在中序遍历数组中的下标
        int inorder_root = hashMap.get(preorder[preorder_root]);

        //创建当前节点
        TreeNode newRoot = new TreeNode(preorder[preorder_root]);
        //计算左子树的元素数量（【注意】下标都是闭区间下标）
        int size_left_subtree = inorder_root - inorder_left;

        //递归构造左子树，并连接到根节点
        //先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        //【注意】简单起见，计算过程采用闭区间
        newRoot.left = myBuildTree(preorder, inorder,
                preorder_left + 1, preorder_left + size_left_subtree,
                inorder_left, inorder_root - 1);

        //递归地构造右子树，并连接到根节点
        //先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        //【注意】简单起见，计算过程采用闭区间
        newRoot.right = myBuildTree(preorder, inorder,
                preorder_left + size_left_subtree + 1, preorder_right,
                inorder_root + 1, inorder_right);

        return newRoot;
    }




}
