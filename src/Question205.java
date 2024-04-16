import java.util.HashMap;

/**
 * 205.同构字符串
 */
public class Question205 {
    /**
     * 【HashMap】【官方题解】思路比较简单，直接使用两个HashMap分别存储s到t和t到s的映射关系。
     * 时间复杂度：O(N)，N表示字符串长度。
     * 空间复杂度：O(|S|),S表示字符集。
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> s2t = new HashMap<>();
        HashMap<Character, Character> t2s = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            if ((s2t.containsKey(chs) && s2t.get(chs) != cht)
                    || (t2s.containsKey(cht) && t2s.get(cht) != chs)) {
                return false;
            }
            s2t.put(chs, cht);
            t2s.put(cht, chs);
        }

        return true;
    }


    /**
     * 【HashMap】【最优解】自己想的，将两个字符串中的字符分别作为key和value，挨个遍历是否存在不止一种组合。
     * 只需要一个HashMap，相比于官方题解，本方法实际运行效率更高。
     * 时间复杂度：O(N)，N表示字符串长度。
     * 空间复杂度：O(|S|),S表示字符集。
     */
    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            if (map.containsKey(chs)) {
                if (map.get(chs) != cht) {
                    return false;
                }
            } else {
                //**********这里很容易漏掉
                //思考用例：s="babc", t="baba",结果应输出false，这里漏加将输出true。
                if (map.containsValue(cht)) {
                    return false;
                }
                //**************************
                map.put(chs, cht);
            }
        }

        return true;
    }
}
