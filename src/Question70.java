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
        //递推公式：f(n) = f(n - 1) + f(n - 2)，
        // 声明三个变量分别记录：
        // p: f(n - 2)
        // q: f(n - 1)
        // r: f(n)
        int p = 0, q = 1, r = 1;//这里变量的初始值不着急填，等写循环实现递推公式时再看怎样初始化能满足初次计算。
        for (int i = 0; i < n; ++i) {
            r = p + q;//1.实现递推公式
            p = q;//2.f(n - 1)赋值给f(n - 2)，以备下一次运算
            q = r;//3.f(n)赋值给f(n - 1)，以备下一次运算
        }
        return r;
    }
}
