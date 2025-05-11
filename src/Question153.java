//153. 寻找旋转排序数组中的最小值
public class Question153 {
    /**
     * 【最优解】【题解看的】可以把整个旋转后的数组，分为左右两个部分，两个部分分别单调递增，左半部分所有元素严格大于右半部分所有元素。
     * 所以在二分时，如果mid元素小于right元素，则最小值下标肯定<=mid，令right = mid - 1继续寻找；
     * 否则最小值小标肯定大于mid，令left = mid + 1继续寻找；
     * 套用头Max二分模板，左右边界初始为0和length-1、符号采用<=，二分过程中最小值肯定会被mid遍历到，单独记录了变量minValue更新最小值。
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int minValue = Integer.MAX_VALUE;

        //虽然通过调整二分时的符号和遍历细节可以直接在遍历之后把nums[left]作为返回的结果，但是细节比较复杂，
        // 这里直接记录一个最小值结果minValue，每次遍历后进行比较更新，简单很多。
        // 只要确保最小值会被mid遍历到即可。
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //用mid对应的元素比较更新最小值
            minValue = Math.min(nums[mid], minValue);
            if (nums[mid] < nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return minValue;
    }
}
