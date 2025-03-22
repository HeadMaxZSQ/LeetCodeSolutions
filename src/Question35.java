/**
 * 35. 搜索插入位置
 */
public class Question35 {
    /**
     * 【真正的最优解】【头Max二分方法论】
     * 时间复杂度：二分查找的时间复杂度为O(logN)
     * 空间复杂度：O(1)
     */
    public int searchInsert2(int[] nums, int target) {
        //按照2025.3.22借助DeepSeek得出的方法论来解决
        //这里可以把题目理解为：寻找所有小于target的数字的右边界的下标，即小于target的最大数字的下标。若过程中找到target则直接返回。
        int smallerIndex = -1;//【注意】边界问题增加一个变量用于存储最终结果下标，这个下标可能不存在，所以初始值为-1；【找右边界把结果初始值设为-1】
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                smallerIndex = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        if (smallerIndex == -1) {
            //说明不存在比target小的元素
            return 0;
        }  else {
            return smallerIndex + 1;
        }
    }
}
