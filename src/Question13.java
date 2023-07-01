import java.util.HashMap;
import java.util.Map;

public class Question13 {
    //注意初始化HashMap的方式，两个大括号
    Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    /*
    一言蔽之，把一个小值放在大值的左边，就是做减法，否则为加法。
    时间：O(N);空间：O(1)
     */
    public int romanToInt(String s) {
        int sum = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int value = map.get(s.charAt(i));
            if (i < length - 1 && value < map.get(s.charAt(i + 1))) {
                sum -= value;
            } else {
                sum += value;
            }
        }
        return sum;
    }
}
