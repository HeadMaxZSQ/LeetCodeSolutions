import java.util.HashSet;
import java.util.List;

/**
 * 139.单词拆分
 */
public class Question139 {

    /**
     * 【结合题解修改】【较优解】采用嵌套循环进行遍历，依次填写dp[i]
     * 递推公式：dp[i] = check(s[0,i]) || (dp[j] && check(s[j + 1,i]))
     * 时间复杂度：O(n^2)，嵌套循环。
     * 空间复杂度：O(n)
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty()) return false;
        //1.使用HashSet作为判断是否存在的容器
        HashSet<String> set = new HashSet<>(wordDict);
        //2.初始化dp数组
        boolean[] dp = new boolean[s.length()];
        //3.初始化dp[0]初始值
        dp[0] = set.contains(s.substring(0, 1));
        //4.遍历s填写dp[i]
        for (int i = 0; i < s.length(); ++i) {
            //5.实现递推公式
            if (set.contains(s.substring(0, i + 1))) {
                //如果s[0,i]直接在字典中，则直接填true。
                dp[i] = true;
            } else {
                //将s[0,i]拆分为s[0,j]和s[j + 1,i]，要求dp[j]为true，并且s[j + 1,i]在字典中。
                for (int j = 0; j < i; ++j) {
                    if (dp[j] && set.contains(s.substring(j + 1, i + 1))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}
