import java.util.*;

/*
边长数组+HashMap
变长数组可以在 O(1)O(1) 的时间内完成获取随机元素操作，但是由于无法在 O(1)O(1) 的时间内判断元素是否存在，
因此不能在 O(1)O(1) 的时间内完成插入和删除操作。哈希表可以在 O(1)O(1) 的时间内完成插入和删除操作，
但是由于无法根据下标定位到特定元素，因此不能在 O(1)O(1) 的时间内完成获取随机元素操作。
为了满足插入、删除和获取随机元素操作的时间复杂度都是 O(1)O(1)，需要将变长数组和哈希表结合，变长数组中存储元素，
哈希表中存储每个元素在变长数组中的下标。
 */
public class Question380 {
    class RandomizedSet {
        List<Integer> nums;
        Map<Integer, Integer> map;
        Random random;

        public RandomizedSet() {
            nums = new ArrayList<Integer>();
            map = new HashMap<Integer, Integer>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            int index = nums.size();
            map.put(val, index);
            nums.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            /*
            将数组中最后一个元素换到val的位置，并更新map信息
             */
            int lastIndex = nums.size() - 1;
            int valIndex = map.get(val);
            nums.set(valIndex, nums.get(lastIndex));
            map.put(nums.get(lastIndex), valIndex);
            nums.remove(lastIndex);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            int index = random.nextInt(nums.size());
            return nums.get(index);
        }
    }
}
