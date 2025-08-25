/**
 * 136. 只出现一次的数字
 */
public class Question136 {
    /**
     * 【最优解】【题解看的】利用异或的特性：
     * 1.任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a。
     * 2.任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
     * 3.异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
