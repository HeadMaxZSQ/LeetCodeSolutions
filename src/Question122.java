public class Question122 {
    /*
    贪心算法。第m天到第n天区间的收益可以拆分成每天每天买卖的收益相加，
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

    //todo 补充动态规划解法
}
