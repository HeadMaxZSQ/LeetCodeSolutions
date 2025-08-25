/**
 * 137. 只出现一次的数字 II
 */
public class Question137 {
    /**
     * 【较优解】【题解看的】依次确定每一个二进制位
     * 考虑答案的第 i 个二进制位（i 从 0 开始编号），它可能为 0 或 1。
     * 对于数组中非答案的元素，每一个元素都出现了 3 次，对应着第 i 个二进制位的 3 个 0 或 3 个 1，无论是哪一种情况，它们的和都是 3 的倍数（即和为 0 或 3）。
     * 因此：
     * 答案的第 i 个二进制位就是数组中所有元素的第 i 个二进制位之和除以 3 的余数。
     *
     * 时间复杂度：O(nlogC)，其中 n 是数组的长度，C 是元素的数据范围，在本题中 logC=log2^32 =32，也就是我们需要遍历第 0∼31 个二进制位。
     * 空间复杂度：O(1)。
     */
    public int singleNumber(int[] nums) {
        int result = 0;
         for (int i = 0; i < 32; ++i) {
             int bitSum = 0;
             for (int num: nums) {
                 bitSum += ((num >> i) & 1);
             }
             if (bitSum % 3 != 0) {
                 result |= (1 << i);
             }
         }
         return result;
    }
}
