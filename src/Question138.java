import java.util.HashMap;

/**
 * 138.随机链表的复制
 */
public class Question138 {

    /**
     * 【写这个够了】【自己想的】使用HashMap记录元素映射关系，遍历两边，第一遍复制链表，第二遍random赋值。
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public Node copyRandomList(Node head) {
        Node node = head;
        Node result = null;
        Node lastNode = null;
        HashMap<Node, Node> old2NewMap = new HashMap<>();
        //第一遍遍历，复制链表，并用HashMap记录旧链表节点与新链表节点的映射关系。
        while (node != null) {
            Node newNode = new Node(node.val);
            if (result == null) {
                result = lastNode = newNode;
            } else {
                lastNode.next = newNode;
                lastNode = newNode;
            }
            //记录映射关系
            old2NewMap.put(node, newNode);
            node = node.next;
        }

        //第二遍遍历，从map中去除random节点为新链表赋值。
        node = head;
        while (node != null) {
            Node newNode = old2NewMap.get(node);
            if (node.random == null) {
                newNode.random = null;
            } else {
                newNode.random = old2NewMap.get(node.random);
            }
            node = node.next;
        }

        return result;
    }

    // Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
