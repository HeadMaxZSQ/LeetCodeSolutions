import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question151 {
    /*
    方法一：自己想的，双指针从后向前遍历（性能最优）
    时间：O（N），空间：O（N）
     */
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int left = s.length() - 1;
        int right = left;
        boolean wordFlag = false;
        while (left >= 0) {
            if (s.charAt(left) != ' ' && !wordFlag) {
                wordFlag = true;
                right = left;
            } else if (s.charAt(left) == ' ' && wordFlag) {
                wordFlag = false;
                sb.append(s.substring(left + 1, right + 1)).append(" ");
            }
            left--;
        }
        if (wordFlag) {
            sb.append(s.substring(left + 1, right + 1));
        } else {
            sb.substring(0, sb.length() - 1);
        }
        return sb.toString();
    }

    /*
    方法二：题解看的，使用api
    1.去掉头尾空格；2.拆分为List，同时解决连续多个空格的情况；3.List翻转；4.使用String.join将List转为String
    时间：O（N）；空间：O（N）
     */
    public String reverseWords2(String s) {
        //去掉字符串头尾空格
        s.trim();
        //字符串根据空格分割转为List，注意这里不能直接用" "，而需要使用正则表达式"\\s+"，来解决两个字符串间存在多个空格的情况
        List<String> list = Arrays.asList(s.split("\\s+"));
        //List翻转
        Collections.reverse(list);
        //使用String.join方法将list转为字符串，同时设置分隔符为空格
        return String.join(" ", list);
    }


    /*
    方法三：题解看的，不使用api
    1.去掉头尾空格，中间连续多个空格的情况转为1个；2.整体翻转字符串；3.翻转每个单词
    时间：O（N）；空间：O（N）
     */
    public String reverseWords3(String s) {
        StringBuilder sb = trimString(s);

        reverse(sb, 0, sb.length() - 1);

        reverseEachWord(sb);

        return sb.toString();
    }

    /*
    1.去除头尾空格
    2.单词间连续多个空格仅保留一个
     */
    public StringBuilder trimString(String s) {
        int left = 0;
        int length = s.length();
        int right = length - 1;
        while (left < length) {
            if (s.charAt(left) != ' ') break;
            left++;
        }
        while (right >= 0) {
            if (s.charAt(right) != ' ') break;
            right--;
        }
        //【字符串连续空格只保留一个】
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            if ((s.charAt(left) != ' ') || (sb.charAt(sb.length() - 1) != ' ')) {
                sb.append(s.charAt(left));
            }
            left++;
        }
        return sb;
    }

    //【翻转字符串】的写法要熟练
    public void reverse(StringBuilder sb, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            char temp =  sb.charAt(startIndex);
            sb.setCharAt(startIndex, sb.charAt(endIndex));
            sb.setCharAt(endIndex, temp);
            startIndex++;
            endIndex--;
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int left = 0;
        int right = 0;
        int length = sb.length();

        while (right < length) {
            if (sb.charAt(right) == ' ') {
                reverse(sb, left, right - 1);
                left = right + 1;
            } else if (right == length - 1) {
                reverse(sb, left, right);
            }
            right++;
        }
    }
}
