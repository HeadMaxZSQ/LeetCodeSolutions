public class Question27 {
    //双指针从两头相聚
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        if (nums.length == 1) return (nums[0] == val) ? 0 : 1;
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right--];
            } else {
                left++;
            }
        }
        return left;
    }

    //题解看来的，感觉比较巧妙，没想到
    public int removeElement2(int[] nums, int val) {
        int index = 0;
        for (int num : nums) {
            if (num != val) nums[index++] = num;
        }
        return index;
    }
}
