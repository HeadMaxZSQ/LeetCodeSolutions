public class Question134 {
    /*
    题目思路：我们首先检查第 00 个加油站，并试图判断能否环绕一周；如果不能，就从第一个无法到达的加油站开始继续检查。
    原理：假设从x加油站出发经过z加油站最远能到达y加油站，那么从z加油站直接出发，不可能到达y下一个加油站。
    因为从x出发到z加油站时肯定还有存储的油，这都到不了y的下一站，而直接从z出发刚开始是没有存储的油的，所以更不可能到达y的下一站。
    时间：O(N)；空间：O(1)
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int currentGas = 0;
        int stepCount = 0;
        int i = 0;
        //因为逻辑中需要调整i的值，用for循环反而不方便
        while (i < length) {
            currentGas = 0;
            stepCount = 0;
            while (stepCount < length) {
                int index = (i + stepCount) % length;
                currentGas += gas[index];
                if (currentGas >= cost[index]) {
                    currentGas -= cost[index];
                    stepCount++;
                    continue;
                } else {
                    break;
                }
            }
            if (stepCount == length) {
                //说明走完一圈
                return i;
            } else {
                //没走完一圈，从这次遍历到的下一个位置开始
                i += stepCount + 1;
            }
        }
        return -1;
    }
}
