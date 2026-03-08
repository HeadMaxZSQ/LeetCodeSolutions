/**
 * 88.合并两个有序数组
 */
public class Question88 {

    /**
     * 【自己想的】【最优解】逆向双指针，使用两个指针分别从后往前遍历数组，将较大元素赋值到nums1的末尾。
     * 这题很自然想到用双指针，正向双指针需要创建一个临时数组用于保存排序结果，
     * 这样虽然时间复杂度是O(n+m)，但是空间复杂度也是O(n+m)，所以思考能否不创建额外空间。
     * 故想到从后往前遍历，比较结果直接赋值到nums1末尾。
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int currentIndex = m + n - 1;
        int index1 = m - 1;
        int index2 = n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 >= 0 && index2 >= 0) {
                if (nums1[index1] > nums2[index2]) {
                    nums1[currentIndex--] = nums1[index1--];
                } else {
                    nums1[currentIndex--] = nums2[index2--];
                }
            } else if (index1 >= 0) {
                nums1[currentIndex--] = nums1[index1--];
            } else {
                nums1[currentIndex--] = nums2[index2--];
            }
        }
    }
}
