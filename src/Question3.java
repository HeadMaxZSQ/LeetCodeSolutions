import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串
 */
public class Question3 {
    /**
     * 【滑动窗口思想】注意滑动窗口的思想，是一种特殊的双指针：固定左指针，移动右指针（窗口增大），移动过程中不断计算更新目标结果，
     * 当右指针不再满足条件时，移动左指针直到满足条件位置（窗口缩小）。
     */

    //【最优解】【滑动窗口+HashMap】
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int length = s.length();
        int maxSubStrLen = 0;
        HashMap<Character, Character> map = new HashMap<>();
        //固定左指针，移动右指针
        while (right < length) {
            char ch = s.charAt(right);
            //判断当前右指针指向的字符是否已经包含在HashMap中，如果是，则移动左指针直到字符不被HashMap包含 或 左右指针重合。
            while (map.containsKey(ch) && left < right) {
                map.remove(s.charAt(left));
                left++;
            }
            map.put(ch, ch);
            maxSubStrLen = Math.max(map.size(), maxSubStrLen);
            right++;
        }
        return maxSubStrLen;
    }
}
