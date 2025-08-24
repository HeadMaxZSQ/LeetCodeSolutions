/**
 * 191.位1的个数
 */
public class Question191 {
    /**
     * 【最优解】【自己想的】循环检查每一位，每次检查完一位进行无符号右移以备下一次检查
     * 时间复杂度：O(k)，其中 k 是 int 型的二进制位数，k=32。我们需要检查 n 的二进制位的每一位，一共需要检查 32 位。
     * 空间复杂度：O(1)，我们只需要常数的空间保存若干变量。
     */
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; ++i) {
            if ((n & 1) == 1) {
                result++;
            }
            n = n >>> 1;
        }
        return result;
    }
}
