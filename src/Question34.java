/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class Question34 {
    /**
     * 【自己想的】【最优解】寻找左边界和有边界即可
     * 时间复杂度：O(logN)
     * 空间复杂度：O(N)
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};

        //寻找左边界
        int left = 0;
        int right = nums.length - 1;
        int leftBoundary = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                leftBoundary = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        //剪枝，如果左边界没有找到，说明根本不存在这个元素，直接返回[-1, -1]
        if (leftBoundary == -1) {
            return result;
        }

        //寻找右边界
        left = leftBoundary;//剪枝，这里直接从左边界往右开始找就行
        right = nums.length - 1;
        int rightBoundary = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                rightBoundary = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        result[0] = leftBoundary;
        result[1] = rightBoundary;
        return result;
    }
}
