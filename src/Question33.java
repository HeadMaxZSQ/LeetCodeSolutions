/**
 * 33. 搜索旋转排序数组
 */
public class Question33 {
    /**
     * 【自己想的】【较优解】比官方题解容易理解一些
     * 因为是升序列，所以旋转之后一定有nums[length-1] < nums[0]（除非旋转后恢复原状）
     * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     * 这样就可以看作是两个升序列拼接，记作[S1, S2]，其中S2子序列的最大元素小于S1子序列的最小元素
     * 如果target小于nums[0]，则target一定在S2子序列，否则在S1子序列。
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int firstNum = nums[0];
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                if (nums[mid] < firstNum) {//当前位置在S2
                    if (target < firstNum) {//target位置在S2
                        left = mid + 1;
                    } else {//target位置在S1
                        right = mid - 1;
                    }
                } else {//当前位置在S1
                    if (target < firstNum) {//target位置在S2
                        return -1;//target肯定不存在，直接返回-1
                    } else {//target位置在S1
                        left = mid + 1;
                    }
                }
            } else if (nums[mid] > target) {
                if (nums[mid] < firstNum) {//当前位置在S2
                    if (target < firstNum) {//target位置在S2
                        right = mid - 1;
                    } else {//target位置在S1
                        right = mid - 1;
                    }
                } else {//当前位置在S1
                    if (target < firstNum) {//target位置在S2
                        left = mid + 1;
                    } else {//target位置在S1
                        right = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}
