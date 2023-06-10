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
}
