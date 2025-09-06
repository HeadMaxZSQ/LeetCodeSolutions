/**
 * 198. 打家劫舍
 */
public class Question198 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        //递推公式：f(n) = Max(f(n - 1), f(n - 2) + nums[n])
        // 声明三个变量分别记录：
        // p: f(n - 2)
        // q: f(n - 1)
        // r: f(n)
        int p = 0, q = 0, r = nums[0];//这里变量的初始值不着急填，等写循环实现递推公式时再看怎样初始化能满足初次计算。
        for (int num : nums) {
            r = Math.max(q, p + num);//1.实现递推公式
            p = q;//2.f(n - 1)赋值给f(n - 2)，以备下一次运算
            q = r;//3.f(n)赋值给f(n - 1)，以备下一次运算
        }
        return r;
    }
}
