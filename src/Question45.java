public class Question45 {
    /*
    【贪心算法】每次要跳的时候都跳到最大步数即可，记录步数
     */
    public int jump(int[] nums) {
        int end = 0;
        int maxIndex = 0;
        int step = 0;
        //注意这里条件为（i < nums.length - 1），否则当i=nums.length-1恰好为end时，将增加一次额外的步数。
        for (int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (i == end) {
                end = maxIndex;
                step++;
            }
        }
        return step;
    }
}
