public class Question6 {

    /*
    自己想的方法，初始化numRows个StringBuilder，用于存放每行的字母
    时间：O（N）；空间：O（N）
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        //创建一个StringBuilder数组，每个StringBuilder用于存储一行的字母
        StringBuilder[] bufList = new StringBuilder[numRows];
        //字母位置循环变化的最小周期factor
        int factor = numRows + (numRows - 2);
        int length = s.length();
        //循环遍历字符串中所有字母，并将它们放到对应行的StringBuilder中
        for (int i = 0; i < length; i++) {
            int temp = i % factor;
            if (temp >= numRows) {
                temp = numRows - 2 - (temp - numRows);
            }
            if (bufList[temp] == null) bufList[temp] = new StringBuilder();
            bufList[temp].append(s.charAt(i));
        }

        //使用StringBuilder数组组装结果
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (bufList[i] != null) result.append(bufList[i]);
        }
        return result.toString();
    }

    /*
    题解的没有自己想的这个好
     */
}
