/**
 * 21.合并两个有序链表
 */
public class Question21 {

    /**
     * 【最优解】对比一下自己写的，虽然时间空间复杂度差不多，但是有一些巧思。
     * 时间复杂度：O(m+n)，m和n分别为两个链表的长度。
     * 空间复杂度：O(1)。
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //【巧思1】：创建头节点的头节点，方便处理。
        ListNode preHead = new ListNode(-1);
        ListNode lastNode = preHead;
        //【巧思2】：使用&&而不是||，只需要遍历完一个链表即可，另外一个之间拼接到末尾，相当于剪枝。
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                lastNode.next = list1;
                list1 = list1.next;
            } else {
                lastNode.next = list2;
                list2 = list2.next;
            }
            lastNode = lastNode.next;
        }
        //拼接剩余的链表。
        lastNode.next = (list1 != null) ? list1 : list2;

        return preHead.next;
    }

    /**
     * 【自己想的】写这个也够了
     * 时间复杂度：O(m+n)，m和n分别为两个链表的长度。
     * 空间复杂度：O(1)。
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode result = null;
        ListNode lastNode = null;

        while(list1 != null || list2 != null) {

            //找到当前应该选择的节点
            ListNode node = null;
            int val1 = (list1 != null) ? list1.val : Integer.MAX_VALUE;
            int val2 = (list2 != null) ? list2.val : Integer.MAX_VALUE;
            if (val1 < val2) {
                node = list1;
                list1 = list1.next;
            } else {
                node = list2;
                list2 = list2.next;
            }

            //将节点加入结果中
            if (result == null) {
                result = node;
            } else {
                lastNode.next = node;
            }
            lastNode = node;
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
