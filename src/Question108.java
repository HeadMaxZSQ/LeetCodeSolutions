/**
 * 108. 将有序数组转换为二叉搜索树
 */
public class Question108 {

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
     * 【最优解】【自己想的】递归中序遍历
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        return generateBST(nums, 0, nums.length - 1);
    }

    private TreeNode generateBST(int[] nums, int leftIndex, int rightIndex) {
        //退出条件
        if (leftIndex > rightIndex) return null;

        //计算当前可选区间的中间位置下标（因为这里默认向下取整，所以要么选到中间，要么是中间的左边）
        int middleIndex = (rightIndex + leftIndex) / 2;

        //创建根节点
        TreeNode root = new TreeNode(nums[middleIndex]);

        //递归建立左子树和右子树
        root.left = generateBST(nums, leftIndex, middleIndex - 1);
        root.right = generateBST(nums, middleIndex + 1, rightIndex);

        return root;
    }
}
