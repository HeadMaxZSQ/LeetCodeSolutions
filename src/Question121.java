public class Question121 {
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

    //todo 后续补充动态规划解法，感觉会更通用。
}
