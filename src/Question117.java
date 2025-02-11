import java.util.LinkedList;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 */
public class Question117 {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * 【较优解】【层序遍历（广度优先搜索）】遍历每一层时进行连接
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)，即queue的空间。
     */
    public Node connect(Node root) {
        if (root == null) return null;

        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node lastNode = null;
            while (size > 0) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (lastNode != null) {
                    lastNode.next = node;
                }
                lastNode = node;
                size--;
            }
        }

        return root;
    }
}
