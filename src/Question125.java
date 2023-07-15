public class Question125 {
    //方法三直接双指针比较最优

    /*
    方法一：自己想的，双指针。先处理字符串，去掉字母数字以外的其它字符
    需要记住2个api：
    Character.isLetterOrDigit(char ch);
    Character.toLowerCase(char ch);
    时间：O（N）；空间：O（N）
     */
    public boolean isPalindrome(String s) {
        //创建StringBuilder用于保存去除其它字符之后的字符串
        StringBuilder sb = new StringBuilder();
        int strLen = s.length();
        for (int i = 0; i < strLen; i ++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            }
        }
        //使用双指针判断字符串是否回文
        int newStrLen = sb.length();
        int left = 0;
        int right = newStrLen - 1;
        while (left < right) {
            //比较是顺便转为小写
            if (Character.toLowerCase(sb.charAt(left)) != Character.toLowerCase(sb.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    /*
    方法二：题解看的，将处理后的字符串str与str的倒序字符串比较
    需要记住3个api：
    StringBuilder的拷贝构造
    StringBuilder.reverse()
    String.toLowerCase();
    时间：O（N）；空间：O（N）
     */
    public boolean isPalindrome2(String s) {
        //创建StringBuilder用于保存去除其它字符之后的字符串
        StringBuilder sb = new StringBuilder();
        int strLen = s.length();
        for (int i = 0; i < strLen; i ++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            }
        }
        //将字符串倒序
        StringBuilder sb_rev = new StringBuilder(sb).reverse();
        //输出比较正序与倒序字符串的结果
        return sb.toString().toLowerCase().equals(sb_rev.toString().toLowerCase());
    }

    /*
    方法三：【最优】题解看的，双指针直接比较，不单独构建StringBuilder
    时间：O（N）；空间：O（1）
     */
    public boolean isPalindrome3(String s) {
        int len = s.length();
        int left = 0;
        int right = len - 1;
        //直接双指针比较
        while (left < right) {
            //移动左指针找到字符数字的下标
            while (left < len && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            //移动右指针找到字符数字的下标
            while (right >= 0 && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            //注意！！！这里很容易漏掉！！！如果此时left已经大于等于right了，就不用比较了，直接返回成功
            if (left >= right) {
                return true;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
