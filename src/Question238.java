public class Question238 {
    /*
    前言：
    这似乎是一个简单的问题，可以在线性时间和空间内解决。先计算给定数组所有元素的乘积，然后对数组中的每个元素 xx，
    将总的乘积除以 xx 来求得除自身值的以外数组的乘积。然而这样的解决方法有一个问题，就是如果输入数组中出现 0，
    那么这个方法就失效了。而且在问题中说明了不允许使用除法运算。这增加了这个问题的难度。
     */


    /*
    我们不必将所有数字的乘积除以给定索引处的数字得到相应的答案，
    而是利用索引左侧所有数字的乘积和右侧所有数字的乘积（即前缀与后缀）相乘得到答案。
    初始化两个空数组 L 和 R。对于给定索引 i，L[i] 代表的是 i 左侧所有数字的乘积，R[i] 代表的是 i 右侧所有数字的乘积。
    时间：O(N)；空间：O(N)
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] L = new int[length];
        int[] R = new int[length];
        int[] answer = new int[length];

        //初始化L数组
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }

        //初始化R数组
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }

        //生成结果
        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }

        return answer;
    }

    /*
    改进空间复杂度的方法
    由于输出数组不算在空间复杂度内，那么我们可以将 L 或 R 数组用输出数组来计算。先把输出数组当作 L 数组来计算，
    然后再动态构造 R 数组得到结果。
    时间：O(N)；空间：O(1)（输出数组不算在空间复杂度内）
     */
    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        //将输出数组当作L数组先初始化
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        //R只记录一个，遍历生成结果的同时计算最近的R
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            answer[i] = answer[i] * R;
            R = R * nums[i];
        }

        return answer;
    }
}
