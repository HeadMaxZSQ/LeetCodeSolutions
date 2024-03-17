import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15.三数之和
 */
public class Question15 {

    //【最优解】先对数组排序，然后将三数之和问题转换为两数之和问题。
    //时间复杂度：排序复杂度O(NlogN)，外层循环O(N)，twoSum方法O(N)，所以最终时间复杂度为O(N*N)。
    //空间复杂度：O(1)
    public List<List<Integer>> threeSum(int[] nums) {
        //对数组进行排序，方便使用双指针判断
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();

        //固定一个数字，将三数之和问题转换为两数之和问题。
        for (int i = 0; i < nums.length; ++i) {
            //【注意】为了避免重复解，这里必须要对数字的重复性进行判断。
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            //固定第一个数字，然后对右边所有数字使用双指针超出另外两个数字，转换为两数之和问题。
            List<List<Integer>> tempList = twoSum(nums, i + 1, nums.length - 1, nums[i]);
            if (tempList.size() != 0) {
                answer.addAll(tempList);
            }
        }
        return answer;
    }

    private List<List<Integer>> twoSum(int[] nums, int startIndex, int endIndex, int value) {
        List<List<Integer>> answer = new ArrayList<>();
        while (startIndex < endIndex) {
            int sum = nums[startIndex] + nums[endIndex];
            //当前组合满足三数之和为0
            if (sum + value == 0) {
                //将三数加入返回结果中
                List<Integer> tempList = new ArrayList<>();
                tempList.add(value);
                tempList.add(nums[startIndex]);
                tempList.add(nums[endIndex]);
                answer.add(tempList);

                //为了防止得到重复答案，对相同数字进行排除
                //【注意】这里判断条件要写startIndex < endIndex而不能写startIndex < nums.length，减少不必要的遍历并防止越界。
                while (startIndex < endIndex && nums[startIndex] == nums[startIndex + 1]) {
                    startIndex++;
                }
                //【注意】这里判断条件要写endIndex > startIndex而不能写endIndex > 0，减少不必要的遍历并防止越界。
                while (endIndex > startIndex && nums[endIndex] == nums[endIndex - 1]) {
                    endIndex--;
                }

                //移动指针
                startIndex++;
                endIndex--;
            } else if (sum + value < 0) {
                startIndex++;
            } else if (sum + value > 0) {
                endIndex--;
            }
        }
        return answer;
    }

    /*
    * 暴力解法：三重循环
    * 时间复杂度：O(N*N*N)  空间复杂度：O(1)
    */
    //略
}
