import java.util.Arrays;

public class Question274 {
    /*
    将citations排序。
    时间：O(nlogn)，排序的时间复杂度。
    空间：O(logn)，排序的空间复杂度。
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            i--;
            h++;
        }
        return h;
    }
}
