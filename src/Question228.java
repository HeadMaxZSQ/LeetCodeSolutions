import java.util.ArrayList;
import java.util.List;

/**
 * 228.汇总区间
 */
public class Question228 {

    /**
     * 【最优解】【官方题解】思路清晰，记住双层while循环
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int len = nums.length;
        while (i < len) {
            //外层循环每次起始位置作为区间左侧
            int left = i;
            i++;
            while (i < len && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            //内层循环移动并最终确定区间右边界
            int right = i - 1;
            //结果默认填入左边界，按需增加右边界
            StringBuffer strBuf = new StringBuffer();
            strBuf.append(nums[left]);
            if (left < right) {
                strBuf.append("->").append(nums[right]);
            }
            result.add(strBuf.toString());
        }
        return result;
    }


    /**
     * 【自己想的】思路简单，但实现容易有疏漏，需要考虑的边界情况较多，如第一个元素、最后一个元素的情况。
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public List<String> summaryRanges2(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add(String.valueOf(nums[0]));
        }
        int startNum = nums[0];
        int lastNum = startNum;
        for (int i = 1; i < nums.length; ++i) {
            int num = nums[i];
            if (num != lastNum + 1) {
                if (lastNum == startNum) {
                    result.add(String.valueOf(lastNum));
                } else {
                    result.add(startNum + "->" + lastNum);
                }
                startNum = num;
                lastNum = startNum;
            } else {
                lastNum = num;
            }

            //【注意】需要特殊判断是否是最后一个数字！！！
            if (i == nums.length - 1) {
                if (num != startNum) {
                    result.add(startNum + "->" + num);
                } else {
                    result.add(String.valueOf(num));
                }
            }
        }

        return result;
    }
}
