public class Question189 {

    /*
    这题就用数组翻转，效率最优并且最容易理解，别的不用看。时间O(n)，空间O(1)。
    1.反转整个数组；2.以k%nums.length为分界线，翻转前半部分；3.翻转后半部分。
     */
    public void rotate(int[] nums, int k) {
        int boundary = k % nums.length;
        reverse2(nums, 0, nums.length - 1);
        reverse2(nums, 0, boundary - 1);
        reverse2(nums, boundary, nums.length - 1);
    }

    //自己写的翻转算法
    public void reverse(int[] nums, int startIndex, int endIndex) {
        int length = endIndex - startIndex;
        int count = (length + 1) / 2;
        for (int i = 0; i < count; i++) {
            int temp = nums[startIndex + i];
            nums[startIndex + i] = nums[endIndex - i];
            nums[endIndex - i] = temp;
        }
    }

    //题解上看的翻转算法，感觉更直观同意理解，推荐使用这个。
    public void reverse2(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
