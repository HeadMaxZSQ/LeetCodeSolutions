import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 */
public class Question17 {

    /**
     * 【较优解】【自己想的】【深度优先搜索（递归遍历）】想象一棵多叉树，digits中从前往后的每个按键是树从上到下的每一层
     * 然后对树进行深度优先搜索
     * 时间复杂度时间复杂度：O(3^m×4^n)，
     * 其中 m 是输入中对应 3 个字母的数字个数（包括数字 2、3、4、5、6、8），
     * n 是输入中对应 4 个字母的数字个数（包括数字 7、9），m+n 是输入数字的总个数。
     * 当输入包含 m 个对应 3 个字母的数字和 n 个对应 4 个字母的数字时，不同的字母组合一共有 3^m×4^n种，需要遍历每一种字母组合。
     * 空间复杂度：O(m+n),递归调用层数最大为 m+n
     */
    HashMap<Character, List<String>> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        map.put('2', Arrays.asList("a","b","c"));
        map.put('3', Arrays.asList("d","e","f"));
        map.put('4', Arrays.asList("g","h","i"));
        map.put('5', Arrays.asList("j","k","l"));
        map.put('6', Arrays.asList("m","n","o"));
        map.put('7', Arrays.asList("p","q","r","s"));
        map.put('8', Arrays.asList("t","u","v"));
        map.put('9', Arrays.asList("w","x","y","z"));

        DFS(digits, "");

        return result;
    }

    private void DFS(String digits, String tempString) {
        if (digits.length() == 0) {
            if (!tempString.isEmpty()) {
                result.add(tempString);
            }
            return;
        }

        char firstCh = digits.charAt(0);
        List<String> charList = map.get(firstCh);
        String newDigits = digits.substring(1);
        for (String ch: charList) {
            DFS(newDigits, tempString + ch);
        }
    }
}
