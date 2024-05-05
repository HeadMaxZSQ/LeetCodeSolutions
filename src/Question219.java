import java.util.HashMap;

/**
 * 219.存在重复元素 II
 */
class Question219 {
    /**
     * 【最优解】直接用HashMap记录最近出现的数字及其下标用于判断。
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //维护一个HashMap，key是数字，value是对应的下标，每次数字出现后刷新HashMap。
        HashMap<Integer, Integer> num2IndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            if (num2IndexMap.containsKey(num) && Math.abs(i - num2IndexMap.get(num)) <= k) {
                return true;
            }
            num2IndexMap.put(num, i);
        }
        return false;
    }
}