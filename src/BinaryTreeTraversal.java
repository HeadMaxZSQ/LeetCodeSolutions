import java.util.*;

public class BinaryTreeTraversal {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 层序遍历
     * 常用队列实现，非递归
     * @param root 根节点
     */
    public static void breadthFirstTraversal(TreeNode root) {
        if (root == null) return;
        //创建队列
        Queue<TreeNode> queue = new LinkedList<>();
        //根节点入队
        queue.offer(root);
        //循环遍历
        while (!queue.isEmpty()) {
            //出队一个节点
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");//打印节点
            //左子节点入队
            if (node.left != null) queue.offer(node.left);
            //右子节点入队
            if (node.right != null) queue.offer(node.right);
        }
    }

    /**
     * 层序遍历之分层输出
     * 比普通层序遍历就多了一步，记录当前队列种剩余节点数（即当前层节点数），并嵌套for循环将当前层全部遍历完。
     * @param root 根节点
     */
    public static void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); //记录当前层节点数量
            //将当前层全部遍历完
            for (int i = 0; i < levelSize; ++i) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            System.out.println();//换行分隔不同层
        }
    }

    // ========== DFS前序遍历 ==========
    // 递归
    public static void preorderRecursive(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorderRecursive(root.left);
        preorderRecursive(root.right);
    }
    // 递归，并记录结果
    public static void preorderRecursiveWithResult(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        preorderRecursiveWithResult(root.left, result);
        preorderRecursiveWithResult(root.right, result);
    }

    // 非递归（使用栈）
    public static List<Integer> preorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        //初始化栈
        Deque<TreeNode> stack = new LinkedList<>();
        //压入根节点
        stack.push(root);
        //循环遍历
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            System.out.print(node.val + " ");
            // 栈后进先出，先压右再压左，保证左子树先处理
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return result;
    }

    // ========== DFS中序遍历 ==========
    // 递归
    public static void inorderRecursive(TreeNode root) {
        if (root == null) return;
        inorderRecursive(root.left);
        System.out.print(root.val + " ");
        inorderRecursive(root.right);
    }

    // 非递归（使用栈）
    public static List<Integer> inorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            // 将当前节点的所有左子节点入栈
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();
            result.add(currentNode.val);
            System.out.print(currentNode.val + " ");

            // 转向右子树
            currentNode = currentNode.right;
        }
        return result;
    }

    // ========== DFS后序遍历 ==========
    // 递归
    public static void postorderRecursive(TreeNode root) {
        if (root == null) return;
        postorderRecursive(root.left);
        postorderRecursive(root.right);
        System.out.print(root.val + " ");
    }

    // 非递归（使用两个栈）
    public static List<Integer> postorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            // 先左后右入栈1，保证出栈1顺序为根、右、左，入栈2顺序为根、右、左，最后栈2出栈为左、右、根
            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }
        while (!stack2.isEmpty()) {
            //stack2直接依次出栈即可
            TreeNode node = stack2.pop();
            result.add(node.val);
            System.out.print(node.val + " ");
        }
        return result;
    }

    public static void main(String[] args) {
        // 构建一个简单二叉树
        //        1
        //       / \
        //      2   3
        //     / \ / \
        //    4  5 6  7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Print BFS traversal result: ");
        breadthFirstTraversal(root);
        System.out.println("\n");

        System.out.println("Print BFS traversal result by level order: ");
        levelOrder(root);
        System.out.println("\n");

        System.out.println("Print DFS preorder recursive: ");
        preorderRecursive(root);
        System.out.println("\n");

        System.out.println("Print DFS preorder iterative: ");
        preorderIterative(root);
        System.out.println("\n");

        System.out.println("Print DFS inorder recursive: ");
        inorderRecursive(root);
        System.out.println("\n");

        System.out.println("Print DFS inorder iterative: ");
        inorderIterative(root);
        System.out.println("\n");

        System.out.println("Print DFS postorder recursive: ");
        postorderRecursive(root);
        System.out.println("\n");

        System.out.println("Print DFS postorder iterative: ");
        postorderIterative(root);
        System.out.println("\n");
    }
}
