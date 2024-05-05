import java.util.HashMap;

/**
 * 1.两数之和
 */
class Question1 {
    /**
     * 【最优解】使用HashMap记录所有出现过的数字及其下标，便于遍历时进行判断。
     * 时间复杂度：O(N)；
     * 空间复杂度：O(N);
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> num2Index = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (num2Index.containsKey(target - nums[i])) {
                return new int[] {num2Index.get(target - nums[i]), i};
            }
            num2Index.put(nums[i], i);
        }
        return new int[0];
    }
}