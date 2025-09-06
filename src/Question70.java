/**
 * 70.爬楼梯
 */
public class Question70 {
    /**
     * 【自己想的】【运行超时!!!】【暴力递归】暴力递归进行动态规划，因为会重复计算某些数字，导致运行超时。
     * 时间复杂度：O(2^n)，深度为n的二叉树递归遍历
     * 空间复杂度：O(n)，深度为n的二叉树递归遍历
     */
    public int climbStairs(int n) {
        if (n <= 2) return n;

        return climbStairs(n - 2) + climbStairs(n - 1);
    }

    /**
     * 【题解看的】【较优解】使用滚动数组的动态规划。
     * tips：暴力递归是反向的从n往前倒推，滚动数组数是正向地从1往后计算。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int climbStairs1(int n) {
        //f(n) = f(n - 1) + f(n - 2)，
        // 声明三个变量分别记录：
        // p: f(n - 2)
        // q: f(n - 1)
        // r: f(n)
        int p = 0, q = 0, r = 1;
        //为了便于思考，循环index就不从0开始，直接考虑1到n级台阶
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
