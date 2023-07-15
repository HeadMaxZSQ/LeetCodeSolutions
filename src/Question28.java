public class Question28 {
    /*
    自己想的方法，暴力遍历，从haystack第一个字符开始挨个遍历判断其是否是可匹配的起始位置。
    时间：O（M*N）；空间：O（1）
     */
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        int startRange = hLen - nLen;
        for (int i = 0; i <= startRange; i++) {
            for (int j = 0; j < nLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
                if (j == nLen - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    /*
    题解KMP算法看着比较复杂，没仔细了解
     */
}
