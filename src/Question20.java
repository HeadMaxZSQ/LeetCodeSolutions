import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 20.有效的括号
 */
public class Question20 {
    /**
     * 【最优解】自己想的，直接使用栈即可。
     * 参考题解进行了剪枝。
     * 时间复杂度：O(n)，其中 n 是字符串 s 的长度。
     * 空间复杂度：O(n+∣Σ∣)，其中 Σ 表示字符集，本题中字符串只包含 6 种括号，∣Σ∣=6。
     * 栈中的字符数量为 O(n)，而哈希表使用的空间为 O(∣Σ∣)，相加即可得到总空间复杂度。
     */
    public boolean isValid(String s) {
        //【题解优化】进行有效剪枝
        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new LinkedList<>();
        //初始化映射表格
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        //遍历字符串
        for (char ch : s.toCharArray()) {
            if (ch == ')' || ch == '}' || ch == ']') {
                if (!stack.isEmpty()) {
                    char left = stack.pop();
                    if (map.get(ch) != left) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        //【注意】这里不能写成return true。必须要栈为空才行。
        return stack.isEmpty();
    }
}
