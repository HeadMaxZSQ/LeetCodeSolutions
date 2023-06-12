import java.util.HashMap;
import java.util.Map;

public class Question169 {
    //哈希表
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num).intValue() + 1);
            } else {
                map.put(num, 1);
            }
        }
        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (maxEntry == null) {
                maxEntry = entry;
            } else {
                if (entry.getValue() > maxEntry.getValue()) {
                    maxEntry = entry;
                }
            }
        }
        return maxEntry.getKey().intValue();
    }
}
