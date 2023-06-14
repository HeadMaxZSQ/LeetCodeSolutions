public class Question121 {
    //Leetcode实测第一种解法效率优于动态规划。尽量用第一种。

    /*
    如果我们真的在买卖股票，我们肯定会想：如果我是在历史最低点买的股票就好了！
    太好了，在题目中，我们只要用一个变量记录一个历史最低价格 minprice，我们就可以假设自己的股票是在那天买的。
    那么我们在第 i 天卖出股票能得到的利润就是 prices[i] - minprice。
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price: prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    /*
    动态规划解法。注意状态转移方程是dp[i] = Math.max(dp[i - 1], prices[i] - minPrice)，因为只能买卖一次。
    时间复杂度O(n);空间复杂度由于使用了滚动数组代替dp数组，所以为O(1)。
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int length = prices.length;
        int p = 0;
        int r = 0;
        int minPrice = prices[0];
        for (int i = 1; i < length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            r = Math.max(p, prices[i] - minPrice);
            p = r;
        }
        return r;
    }
}
