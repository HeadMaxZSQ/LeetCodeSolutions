public class Question167 {
    //方法二最优

    /*
    方法一：暴力寻找，自己想的，蠢得要死。
    时间：O（NlogN），空间：O（1）
     */
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int[] result = new int[2];
        for (int i = 0; i < len; i++) {
            int j = i + 1;
            while (j < len) {
                if (numbers[i] + numbers[j] > target) {
                    break;
                } else if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
                j++;
            }
        }
        return result;
    }

    /*
    方法二：双指针。
    思想：初始时两个指针分别指向第一个元素位置和最后一个元素的位置。每次计算两个指针指向的两个元素之和，并和目标值比较。
    如果两个元素之和等于目标值，则发现了唯一解。如果两个元素之和小于目标值，则将左侧指针右移一位。
    如果两个元素之和大于目标值，则将右侧指针左移一位。移动指针之后，重复上述操作，直到找到答案。
    时间：O（N）；空间：O（1）。
     */
    public int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            }
        }
        return result;
    }
}
