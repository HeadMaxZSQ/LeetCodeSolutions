public class Question82 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 【最优解】【领悟遍历和删除方法】遍历一遍，遍历到重复元素就开启子循环删除所有重复元素。
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public ListNode deleteDuplicates0(ListNode head) {
        if (head == null) return null;
        ListNode preHead = new ListNode(Integer.MIN_VALUE);
        preHead.next = head;
        ListNode node = preHead;
        while (node.next != null && node.next.next != null) {
            if (node.next.val == node.next.next.val) {
                int x = node.next.val;
                //【重点】领悟一下这里的删除逻辑
                while (node.next != null && node.next.val == x) {
                    node.next = node.next.next;
                }
            } else {
                node = node.next;
            }
        }

        return preHead.next;
    }

    /**
     * 【自己想的】利用栈的思想，将不重复的元素入栈，发现重复元素就将栈顶元素出栈
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode preHead = new ListNode(Integer.MIN_VALUE);
        preHead.next = head;
        ListNode stackTop = head;
        ListNode preStackTop = preHead;
        ListNode node = head.next;
        boolean needPop = false;
        while (node != null) {
            if (node.val == stackTop.val) {
                //当前遍历到的元素与栈顶元素值相等，记录需要出栈的标记
                needPop = true;
            } else {
                if (needPop) {                    
                    //栈顶元素不满足唯一性，出栈：preStackTop位置不变，stackTop回退到上一个节点
                    preStackTop.next = null;
                    stackTop = preStackTop;
                    needPop = false;
                }
                stackTop.next = node;
                preStackTop = stackTop;
                stackTop = node;
            }
            node = node.next;
        }

        //【注意】易错点，容易忽略最后一个元素是重复元素的情况。
        if (needPop) {
            preStackTop.next = null;
        }
        return preHead.next;
    }
}
