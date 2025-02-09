public class Question86 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 【自己想的】设置small和big两个链表，遍历一遍原始链表，将元素加入两个链表中。
     * 相比题解中的最优解，思路和性能一样，但题解中运用了preHead，使代码简单很多。
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public ListNode partition(ListNode head, int x) {
        ListNode smallListHead = null;
        ListNode smallNode = null;
        ListNode bigListHead = null;
        ListNode bigNode = null;

        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                if (smallListHead == null) {
                    smallListHead = node;
                    smallNode = node;
                } else {
                    smallNode.next = node;
                    smallNode = node;
                }
                //【易错点】每次入队后，需要接触两个small/big两个链表之间的连接
                if (bigNode != null) bigNode.next = null;
            } else {
                if (bigListHead == null) {
                    bigListHead = node;
                    bigNode = node;
                } else {
                    bigNode.next = node;
                    bigNode = node;
                }
                //【易错点】每次入队后，需要解除两个small/big两个链表之间的连接
                if (smallNode != null) smallNode.next = null;
            }
            node = node.next;
        }

        if (smallListHead == null) {
            return bigListHead;
        } else if (bigListHead == null) {
            return smallListHead;
        } else {
            smallNode.next = bigListHead;
            return smallListHead;
        }
    }

    public ListNode partition1(ListNode head, int x) {
        ListNode preBigListHead = new ListNode(Integer.MIN_VALUE);
        ListNode bigNode = preBigListHead;
        ListNode preSmallListHead = new ListNode(Integer.MIN_VALUE);
        ListNode smallNode = preSmallListHead;

        while (head != null) {
            if (head.val < x) {
                smallNode.next = head;
                smallNode = head;
            } else {
                bigNode.next = head;
                bigNode = head;
            }
            head = head.next;
        }
        
        //【易错点】需要将big链表中最后一个元素的next置为null，防止指向small链表中的节点，解除small/big两个链表之间的连接
        bigNode.next = null;

        //连接small和big链表
        smallNode.next = preBigListHead.next;
        return preSmallListHead.next;
    }
}