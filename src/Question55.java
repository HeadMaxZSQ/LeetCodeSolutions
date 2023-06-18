public class Question55 {
    /*
    记录相对当前位置还能跳跃的最大步数。（自己想的）
     */
    public boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        int maxStep = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (maxStep < 0) return false;
            maxStep = Math.max(maxStep, nums[i]);
            maxStep--;
        }
        return true;
    }

    /*
    【better】直接记录能跳跃到的最远位置的下标。（题解看的）
     */
    public boolean canJump2(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxIndex) return false;
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return true;
    }
}
