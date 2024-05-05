import java.util.HashMap;

/**
 * 290.单词规律
 */
class Question290 {
    /**
     * 【最优解1】【自己想的】只使用一个HashMap来完成【双射】（一一对应）的比对。
     * 时间复杂度：O(N+M),其中n为 pattern的长度，m为str长度
     * 空间复杂度：O(N+M),其中n为 pattern的长度，m为str长度
     */
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap();
        //先将字符串以空格分割，转为字符串数组
        String[] strArray = s.trim().split(" ");
        if (pattern.length() != strArray.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); ++i) {
            char ch = pattern.charAt(i);
            String str = strArray[i];
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(str)) {
                    return false;
                }
            } else {
                if (map.containsValue(str)) {
                    return false;
                } else {
                    map.put(ch, str);
                }
            }
        }
        return true;
    }


    /**
     * 【最优解2】【标准题解】使用两个HashMap来完成【双射】（一一对应）的比对。这样逻辑关系更加清晰。
     * 时间复杂度：O(N+M),其中n为 pattern的长度，m为str长度
     * 空间复杂度：O(N+M),其中n为 pattern的长度，m为str长度
     */
    public boolean wordPattern2(String pattern, String s) {
        HashMap<Character, String> ch2Str = new HashMap<>();
        HashMap<String, Character> str2Ch = new HashMap<>();
        //先将字符串以空格分割，转为字符串数组
        String[] strArray = s.trim().split(" ");
        if (pattern.length() != strArray.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); ++i) {
            char ch = pattern.charAt(i);
            String str = strArray[i];
            if (ch2Str.containsKey(ch) && !ch2Str.get(ch).equals(str)) {
                return false;
            } else {
                ch2Str.put(ch, str);
            }

            if (str2Ch.containsKey(str) && str2Ch.get(str) != ch) {
                return false;
            } else {
                str2Ch.put(str, ch);
            }
        }

        return true;
    }
}