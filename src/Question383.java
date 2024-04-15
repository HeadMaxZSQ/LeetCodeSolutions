import java.util.HashMap;

/**
 * 383.赎金信
 */
public class Question383 {

    /**
     * 【最优解】【数组】不使用HashMap，直接使用数组效率更高……
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(|S|)，S是字符集，|S|=26
     */
    public boolean canConstruct(String ransomNote, String magazine) {

        //剪枝
        if (magazine.length() < ransomNote.length()) return false;

        //遍历magazine，记录26个字母分别的出现次数。
        int[] count = new int[26];
        for (char ch: magazine.toCharArray()) {
            count[ch - 'a']++;
        }

        //遍历ransomNote，判断是否不满足条件。
        for (char ch: ransomNote.toCharArray()) {
            int index = ch - 'a';
            count[index]--;
            if (count[index] < 0) {
                return false;
            }
        }

        return true;
    }


    /**
     * 【哈希表】自己想的，先遍历magazine，统计其中字母出现次数保存在哈希表，再遍历ransomNote进行判断。
     */
    public boolean canConstruct2(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            } else {
                map.put(ch, map.get(ch) - 1);
            }
        }

        return true;
    }
}
