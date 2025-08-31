import java.util.Deque;
import java.util.LinkedList;

/**
 * 9.回文数
 */
public class Question9 {
    /**
     * 【自己想的】【双端队列】先把所有元素放入双端队列，再依次取出并比较首尾元素。
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public boolean isPalindrome(int x) {
        //【注意】需要先进行判断，负数一律不算回文，否则算法出错
        if (x < 0) {
            return false;
        }

        Deque<Integer> deque = new LinkedList<>();
        //1.将左右数字加入双端队列中
        while (x != 0) {
            int mod = x % 10;
            deque.push(mod);
            x = x / 10;
        }
        //2.依次去除首尾元素进行比较
        int half = deque.size() / 2;
        for (int i = 0; i < half; ++i) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 【最优解】【题解看的】从中间将后半部分数字反转，判断是否与前半部分相等
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public boolean isPalindrome2(int x) {
        //【注意】1.必须排除负数；2.必须排除0以外所有各位为0的数。否则算法出错。
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }

        //1.构造反转数字（相当于遍历x的一半）
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + (x % 10);
            x = x / 10;
        }

        //2.反转数字（或反转数字除以10）等于剩余x，即认为是回文
        return revertedNumber == x || revertedNumber / 10 == x;
    }
}
