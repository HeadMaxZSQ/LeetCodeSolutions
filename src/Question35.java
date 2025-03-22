/**
 * 35. 搜索插入位置
 */
public class Question35 {
    /**
     * 【最优解】【自己想的】普通二分查找查找目标值，没找到的话最后再根据情况进行处理
     * 时间复杂度：二分查找的时间复杂度为O(logN)
     * 空间复杂度：O(1)
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        //注意，left < right这种写法退出条件为left==right，此时不会进入循环进行处理，所以循环后面要再判断一下nums[left] == target是否成立。
        while (left < right) {
            //【注意】这里不要写为mid = (left + right) / 2，以防int越界。
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        //因为循环退出条件是left==right，所以这里用left和right都一样
        if (nums[left] == target) {
            return left;
        } else if (nums[left] < target) {//要插入的位置在left左边
            return left + 1;
        } else {//target比当前位置值小，但是肯定比left-1的值大，所以要插入的位置在当前位置
            return left;
        }
    }
}
