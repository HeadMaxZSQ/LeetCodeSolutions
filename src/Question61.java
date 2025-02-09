/**
 * 61. 旋转链表
 */
public class Question61 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 【最优解】【自己想的】先计算链表的长度，然后找到倒数第k个点重新连接
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public ListNode rotateRight(ListNode head, int k) {

        //k为0直接返回
        if (k == 0) return head;

        //计算链表长度，顺便记录最后一个节点供后续连接使用
        int length = 0;
        ListNode node = head;
        ListNode lastNode = null;
        while (node != null) {
            lastNode = node;
            node = node.next;
            length++;
        }

        //数组长度小于等于1直接返回
        if (length <= 1) return head;

        //计算移动后最后一个节点的原始索引，遍历找到这个节点，将这个节点之后的部分重新连接。
        int splitIndex = (length - 1) - (k % length);
        //【易错点】注意在k%length=0的情况下不能进行分割，数组长度等于移动次数，直接返回 
        if (k % length == 0) return head;
        node = head;
        int index = 0;
        while (node != null) {
            if (index == splitIndex) {
                ListNode newHead = node.next;
                node.next = null;
                lastNode.next = head;
                head = newHead;
                break;
            }
            node = node.next;
            index++;
        }

        return head;
    }
}