/**
 * 颠倒二进制位
 */
public class Question190 {
    /**
     * 【题解看的】【较优解】每次&1依次去除对应位的值并放到result的对应位置
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 31; ++i) {
            result |= (n & 1) << (31 - i);
            n = n >>> 1;
        }

        return result;
    }
}
