public class Question58 {
    /*
    自己想的，比题解简洁高效，思路就是反向遍历，统计最后一个单词的长度。
    时间O(N),空间O(1)。
     */
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else if (count != 0) {
                break;
            }
        }
        return count;
    }
}
