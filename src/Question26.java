/**
 * 26. 删除有序数组中的重复项
 */
public class Question26 {
    //快慢指针
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int slow = 1;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    //快慢指针，更容易理解的写法
    public int removeDuplicates2(int[] nums) {
        int slow = 0;
        int fast = 0;
        int currentValue = Integer.MIN_VALUE;
        while (fast < nums.length) {
            if (nums[fast] != currentValue) {
                nums[slow++] = nums[fast];
                currentValue = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
