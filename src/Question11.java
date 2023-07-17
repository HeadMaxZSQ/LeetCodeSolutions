public class Question11 {
    /*
    最优解：双指针。两个指针分别位于头和位，每次移动值较小的指针。
    比较难想到用双指针。
    理论证明：
    面积为：S(i,j)=min(h[i],h[j])×(j−i)
    若向内 移动短板 ，水槽的短板 min(h[i], h[j])min(h[i],h[j]) 可能变大，因此下个水槽的面积 可能增大 。
    若向内 移动长板 ，水槽的短板 min(h[i], h[j])min(h[i],h[j])​ 不变或变小，因此下个水槽的面积 一定变小 。
    时间：O（N）；空间：O（1）
     */
    public int maxArea(int[] height) {
        int maxValue = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                maxValue = Math.max(maxValue, (right - left) * height[left]);
                left++;
            } else {
                maxValue = Math.max(maxValue, (right - left) * height[right]);
                right--;
            }
        }
        return maxValue;
    }
}
