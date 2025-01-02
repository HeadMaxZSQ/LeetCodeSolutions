/**
 * 19. 删除链表的倒数第 N 个结点
 */
public class Question19 {
    /**
     * 【最优解】【自己想的】遍历两遍，第一遍统计链表长度，然后计算出要删除节点的正向序号，第二遍进行删除。
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //1.统计链表长度
        int length = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            length++;
        }

        //2.计算出要删除节点的正向索引
        int deleteIndex = length - n;

        //3.删除节点
        ListNode preHead = new ListNode(-1);
        ListNode lastNode = preHead;
        preHead.next =  head;
        node = head;
        int index = 0;
        while (node != null) {
            if (index == deleteIndex) {
                lastNode.next = node.next;
                return preHead.next;
            }
            lastNode = node;
            node = node.next;
            index++;
        }

        return null;
    }
}
