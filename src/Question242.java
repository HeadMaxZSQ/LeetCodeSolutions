import java.util.Arrays;
import java.util.HashMap;

/**
 * 242.有效的字母异位词
 */
class Question242 {

    /**
     * 【不算最优解】【自己想的】维护两个HashMap，遍历两遍。
     * 时间复杂度：O(N)，N为s的长度。
     * 空间复杂度：O(S)，S为字符集的大小，此处S=26。
     */
    public static boolean isAnagram(String s, String t) {
        //两个HashMap分别用于记录两个字符串中各字母出现的次数。
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        //【剪枝】如果两个字符串长度都不相等，直接返回false。
        if (s.length() != t.length()) {
            return false;
        }
        //初始化，sMap与tMap，仅遍历一次即可。
        for (int i = 0; i < s.length(); ++i) {
            char chS = s.charAt(i);
            if (sMap.containsKey(chS)) {
                sMap.put(chS, sMap.get(chS) + 1);
            } else {
                sMap.put(chS, 1);
            }
            char chT = t.charAt(i);
            if (tMap.containsKey(chT)) {
                tMap.put(chT, tMap.get(chT) + 1);
            } else {
                tMap.put(chT, 1);
            }
        }

        //比对结果
        if (sMap.size() != tMap.size()) {
            return false;
        }
        for (char ch : sMap.keySet()) {
            /** 【注意！！！】这里容易写成sMap.get(ch) != tMap.get(ch)，容易忘记拆箱，比较的是对象。 */
            if (!tMap.containsKey(ch) || sMap.get(ch).intValue() != tMap.get(ch).intValue()) {
                return false;
            }
        }

        return true;
    }

    /**
     * 【最简单的方法】直接将两个字符串进行排序后比较。
     * 时间复杂度：O(nlog⁡n)，其中 nnn 为 s 的长度。排序的时间复杂度为 O(nlog⁡n)，比较两个字符串是否相等时间复杂度为 O(n)，因此总体时间复杂度为 O(nlog⁡n+n)=O(nlog⁡n)。
     * 空间复杂度：O(log⁡n)。排序需要 O(log⁡n) 的空间复杂度。
     */
    public static boolean isAnagram2(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);
        //比较方式1：使用Arrays.equals()直接比较两个数组。
        return Arrays.equals(sCharArray, tCharArray);
        //比较方式2：生成新的String进行比较。
        // String sSortStr = new String(sCharArray);
        // String tSortStr = new String(tCharArray);
        // return sSortStr.equals(tSortStr);
    }
}