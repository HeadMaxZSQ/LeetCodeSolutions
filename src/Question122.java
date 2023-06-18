public class Question122 {
    /*
    【最优】贪心算法。第m天到第n天区间的收益可以拆分成每天每天买卖的收益相加，
    那第m天到第n天的最大利润其实就是吃到所有正的收益，摒弃负收益。
    时间：O(n)；空间：O(1)
     */
    public int maxProfit(int[] prices) {
        int result = 0;
        int length = prices.length;
        for (int i = 1; i < length; i++) {
            result += Math.max(0, prices[i] - prices[i - 1]);
        }
        return result;
    }

    /*
    动态规划解法
    时间：O（n）；空间：O（n）
     */
    public int maxProfit2(int[] prices) {
        //dp[i] = Math.max(dp[i - 1], dp[i - 1] + (prices[i] - prices[i - 1]))
        if (prices.length < 2) {
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < prices.length; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 1] + (prices[i] - prices[i - 1]));
        }
        return dp[prices.length - 1];
    }

    /*
    滚动数组优化的动态规划
    时间：O（n）；空间：O（1）
     */
    public int maxProfit3(int[] prices) {
        //dp[i] = Math.max(dp[i - 1], dp[i - 1] + (prices[i] - prices[i - 1]))
        if (prices.length < 2) {
            return 0;
        }
        int pre = 0;
        for (int i = 1; i < prices.length; ++i) {
            pre = Math.max(pre, pre + (prices[i] - prices[i - 1]));
        }
        return pre;
    }
}
