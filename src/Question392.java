public class Question392 {
    /*
    方法一【最优】：自己想的，双指针，i和sIndex分别是两个字符串的字符下标
    时间：O（M+N）空间：O（1）
     */
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int sIndex = 0;
        for (int i = 0; i < tLen; i++) {
            if (sIndex >= sLen) {
                return true;
            }
            if (s.charAt(sIndex) == t.charAt(i)) {
                sIndex++;
            }
        }
        return sIndex >= sLen;
    }
}
