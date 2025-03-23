/**
 * 74. 搜索二维矩阵
 */
public class Question74 {

    /**
     * 【最优解】【头Max二分方法论】通过两次二分进行查找，先对每行首个元素组成的数组进行二分，找到唯一可能存在target的行，然后再对行进行二分。
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowNum = matrix.length;
        if (rowNum == 0) return false;
        int columnNum = matrix[0].length;
        if (columnNum == 0) return false;

        //先二分查找找出在哪一行，此时只考虑每一行第一个元素，目标是找出比target小的最大的元素，即比target小的元素的有边界
        int targetRowIndex = -1;//寻找边界问题，记录一个变量用于存储最终结果，这个边界可能不存在所以记作-1
        int top = 0;
        int bottom = rowNum - 1;
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                bottom = mid - 1;
            } else if (matrix[mid][0] < target) {
                targetRowIndex = mid;
                top = mid + 1;
            }
        }
        //循环结束时targetRowIndex为target唯一可能存在的行号
        if (targetRowIndex == -1) return false;

        //剪枝
        if (matrix[targetRowIndex][columnNum - 1] < target) return false;

        //第二次循环，在唯一可能存在target的行二分查找
        int left = 0;
        int right = columnNum - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[targetRowIndex][mid] == target) {
                return true;
            } else if (matrix[targetRowIndex][mid] > target) {
                right = mid - 1;
            } else if (matrix[targetRowIndex][mid] < target) {
                left = mid + 1;
            }
        }

        return false;
    }
}
