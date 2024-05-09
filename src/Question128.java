import java.util.HashSet;
import java.util.Set;

/**
 * 128.最长连续序列
 */
public class Question128 {
    /**
     * 【最优解】【HashSet】使用哈希表，考虑暴力算法，其时间复杂度为O(N^2)，将其剪枝为O(N)即可。
     * 剪枝思路：只需要判断num-1是否存在，若存在则不需要讨论num开头的序列，因为肯定不如num-1开头的序列长。
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            numSet.add(num);
        }

        int result = 0;

        for (int num: numSet) {
            //【注意！！！】本题的关键在于这里的剪枝，将时间复杂度从O(N^2)减到O(N)。
            //如果num-1存在，则当前数字num可以直接跳过，不用遍历寻找序列，因为num开头的序列长度肯定没有num-1开头的序列长。
            if (numSet.contains(num - 1)) {
                continue;
            }

            int currentNum = num;
            int sequenceLength = 1;
            while (numSet.contains(currentNum + 1)) {
                currentNum += 1;
                sequenceLength += 1;
            }

            result = Math.max(result, sequenceLength);
        }

        return result;
    }
}
