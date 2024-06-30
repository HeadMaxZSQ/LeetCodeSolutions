import java.util.Deque;
import java.util.LinkedList;

/**
 * 92.反转链表II  【重点真题】
 */
public class Question92 {

    /**
     * 【较优解】【自己想的】遍历一次，遍历反转区间一次，遇到需要反转的区间时，记录下反转区间前后的元素，并将区间中的元素记录到栈中。
     * 由于第一个元素head也可能属于反转区间，所以使用preHead的技巧。
     * 时间复杂度：O(N);空间复杂度O(N)：
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        boolean startReverse = false;
        //使用一个栈来保存要反转的列表元素。
        Deque<ListNode> stack = new LinkedList<>();
        //【注意】使用preHead的技巧
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        //反转区间的前一个点
        ListNode startNode = preHead;
        //反转区间的后一个点
        ListNode endNode = null;
        int index = 0;
        ListNode node = preHead;
        while (node != null) {
            if (!startReverse) {
                if (left == index) {
                    stack.push(node);
                    startReverse = true;
                } else {
                    //找到反转区域的前一个节点
                    startNode = node;
                }
            } else {
                //【注意】无论如何在完成反转前，node都要push到栈中，很容易忘掉最后一个点。
                stack.push(node);
                if (right == index) {
                    //找到反转区域的后一个节点
                    endNode = node.next;
                    ListNode lastNode = startNode;
                    while (!stack.isEmpty()) {
                        ListNode popNode = stack.pop();
                        lastNode.next = popNode;
                        lastNode = popNode;
                    }
                    lastNode.next = endNode;
                    //【注意】完成操作后直接跳出循环！一方面达到剪枝的效果，另一方面防止忘记重新为node复制将造成重复遍历。
                    break;
                }
            }
            index++;
            node = node.next;
        }
        //注意这里不能返回head，要返回preHead.next
        return preHead.next;
    }

    /**
     * 【官方最优解】【头插法】整体思想是：在需要反转的区间里，每遍历到一个节点，让这个新节点来到反转部分的起始位置。
     * 【注意】其中有两个注意点，一定要谨记！！！
     * 时间复杂度：O(N)；空间复杂度：O(1)。
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        int index = 0;
        //【注意】因为第一个元素也可能需要反转，所以使用preHead的技巧。
        ListNode node = preHead;
        //反转区间的前一个元素
        ListNode leftNode = preHead;
        ListNode lastNode = preHead;
        while (node != null) {
            if (index < left) {
                //找到反转区间的前一个元素
                leftNode = node;
            }  else if (index == left) {
                //反转区间的第一个元素，不执行任何操作
                //【注意1】这一步必不可少！！！因为node头插后，node需要赋值为lastNode，如果这里就开始反转则永远无法开始反转后面的元素！
            } else if (index <= right) {
                //拔出当前元素
                lastNode.next = node.next;
                //插入反转区间头部
                node.next = leftNode.next;
                leftNode.next = node;
                //【注意2】一定要将node指向lastNode，因为原来的node已经被替换到前面！
                node = lastNode;
            } else {
                //right之后的直接break。
                break;
            }
            index++;
            lastNode = node;
            node = node.next;
        }
        return preHead.next;
    }
}
