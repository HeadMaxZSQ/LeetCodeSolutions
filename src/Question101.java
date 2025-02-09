public class Question101 {

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
     * 【自己想的】写两个私有方法：二叉树反转和判断二叉树是否相等，将根节点的左子树反转，然后比较左子树与右子树是否相等。
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null || root.right == null) {
            return false;
        }

        invertTree(root.left);

        return isSameTree(root.left, root.right);
    }


    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        if (p.left == null ^ q.left == null) {
            return false;
        }
        if (p.right == null ^ q.right == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    private TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }


    /**
     * 【深度优先搜索（递归）】【最优解】只遍历一次，判断当前两个节点p、q的值相等，然后p的左子树和q的右子树堆成，p的右子树和q的左子树对称。
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public boolean isSymmetric1(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode p, TreeNode q) {
        //如果两个都为空，返回true；如果其中一个为空，返回false。
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        //如果两个节点值不相等，则返回false
        if (p.val != q.val) {
            return false;
        }

        return check(p.left, q.right) && check(p.right, q.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        } else if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null || root.right == null) {
            return false;
        }

        //这里可以用两个queue，也可以只用一个queue，对称的将两边的子节点加入queue，从queue中poll两个节点进行比较。
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();

        queue1.offer(root.left);
        queue2.offer(root.right);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            if (node1.val != node2.val) {
                return false;
            }

            //如果node1和node2树结构不对称，则直接返回false。
            if ((node1.left == null ^ node2.right == null) || (node1.right == null ^ node2.left == null)) {
                return false;
            }

            if (node1.left != null) {
                queue1.offer(node1.left);
                queue2.offer(node2.right);
            }
            if (node1.right != null) {
                queue1.offer(node1.right);
                queue2.offer(node2.left);
            }
        }

        return queue1.isEmpty() && queue2.isEmpty();
    }
}