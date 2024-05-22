/**
 * 2.两数相加
 */
public class Question2 {
    /**
     * 【最优解】自己想的跟题解差不多，直接使用链表模拟加法过程
     * 时间复杂度：O(max(m,n))，m和n分别表示两个链表的长度。
     * 空间复杂度：O(1)，返回值不计入空间复杂度。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode lastNode = null;
        int extra = 0;
        while (l1 != null || l2 != null) {
            int val1 = 0;
            int val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            int sum = val1 + val2 + extra;
            int currentVal = sum % 10;
            ListNode currentNode = new ListNode(currentVal);
            if (result == null) {
                result = currentNode;
            } else {
                lastNode.next = currentNode;
            }
            lastNode = currentNode;
            //【注意】这里计算进位时容易忘记除以10
            extra = (sum - currentVal) / 10;
        }
        if (extra != 0) {
            lastNode.next = new ListNode(extra);
        }
        return result;
    }


    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

