public class Question14 {

    /*
    横向遍历
    依次遍历字符串数组中的每个字符串，对于每个遍历到的字符串，更新最长公共前缀，当遍历完所有的字符串以后，
    即可得到字符串数组中的最长公共前缀。如果在尚未遍历完所有的字符串时，最长公共前缀已经是空串，则最长公共前缀一定是空串。

    时间复杂度：O(mn)，其中 mm 是字符串数组中的字符串的平均长度，nn 是字符串的数量。
        最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
    空间复杂度：O(1)。使用的额外空间复杂度为常数。
     */
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 1) {
            return strs[0];
        }
        String result = strs[0];
        for (int i = 1; i < length; i++) {
            result = getPrefix(result, strs[i]);
            result = getPrefix2(result, strs[i]);
            if (result.isEmpty()) break;
        }
        return result;
    }

    /*
    自己写的取公共前缀的方法，需要StringBuilder，效率低
     */
    public String getPrefix(String strA, String strB) {
        StringBuilder sb = new StringBuilder();
        int maxLength = Math.min(strA.length(), strB.length());
        for (int i = 0; i < maxLength; i++) {
            if (strA.charAt(i) == strB.charAt(i)) {
                sb.append(strA.charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }

    /*
    题解看的取公共前缀的方法，只记录index不用每次操作字符串，效率高很多
     */
    public String getPrefix2(String strA, String strB) {
        int maxLength = Math.min(strA.length(), strB.length());
        int endIndex = 0;
        for (int i = 0; i < maxLength; i++) {
            if (strA.charAt(i) == strB.charAt(i)) {
                endIndex++;
            } else {
                break;
            }
        }
        return strA.substring(0, endIndex);
    }
}
