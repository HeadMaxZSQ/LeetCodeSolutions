import java.util.HashSet;

/**
 * 141.环形链表
 */
public class Question141 {

    /**
     * 【最优解】【快慢指针】使用Floyd判圈算法 aka 龟兔赛跑算法。
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        //定义快指针和慢指针
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            //如果fast为空或fast.next为空，则说明链表有结尾，不存在环。
            if (fast == null || fast.next == null) {
                return false;
            }
            //龟动一格，兔动两格
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 使用HashSet
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public boolean hasCycle2(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            //【注意】这里使用了HashSet.add方法的返回值，在添加元素的同时顺便判断是否重复
            if (!hashSet.add(node)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }
}

 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
