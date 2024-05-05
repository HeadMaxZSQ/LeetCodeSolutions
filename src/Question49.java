import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 49.字母异位词分组
 */
class Question49 {
    /**
     * 【不算最优解但最简单明了】使用将字符串转为Char数组并进行排序，最后再生成字符串进行比对的方式来判断是否是字母异位词。
     * 这种判断方式效率不高，但是最简单明了，其他方式较复杂这里不再深入。
     * 时间复杂度：O(nklog⁡k)，其中 n 是 strs 中的字符串的数量，k 是 strs 中的字符串的的最大长度。需要遍历 n 个字符串，对于每个字符串，需要 O(klog⁡k) 的时间进行排序以及 O(1) 的时间更新哈希表，因此总时间复杂度是 O(nklog⁡k)。
     * 空间复杂度：O(nk)，其中 n 是 strs 中的字符串的数量，k 是 strs 中的字符串的的最大长度。需要用哈希表存储全部字符串。
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        //维护一个HashMap，key为排序后的字符串，value为List<String>，存储所有同一分组的字符串，最后将该map的value转为List返回即可。
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; ++i) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            //以排序后的字符串为key进行比对
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);
            }
        }
        /** 【注意！！！】这里关注一下map转为List的方式，利用了ArrayList传入Collection参数的构造方法。 */
        return new ArrayList<List<String>>(map.values());
    }
}