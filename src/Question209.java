/**
 * 209. 长度最小的子数组
 */
public class Question209 {

    //【最优解】【滑动窗口】
    //每一轮迭代，将 nums[end]加到 sum，如果 sum≥target，则更新子数组的最小长度
    // （此时子数组的长度是 end−start+1，然后将 nums[start]从sum中减去并将start右移，直到 sum<target，
    // 在此过程中同样更新子数组的最小长度。在每一轮迭代的最后，将end右移。
    //时间复杂度O(N)，空间复杂度O(1)。
    public int minSubArrayLen(int target, int[] nums) {
        int answer = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        int length = nums.length;

        while (end < length) {
            sum += nums[end];
            while (sum >= target) {
                answer = Math.min(answer, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

}
