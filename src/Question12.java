public class Question12 {
    /*
    自己想的方法，思路：从大到小计算出每种符号的个数，然后依次拼接。
    写起来代码量太多，显得比较蠢，不建议使用。
    时间O(1);空间O(1)
     */
    public String intToRoman(int num) {
        int currentNum = num;
        int MCount = currentNum / 1000;
        currentNum -= MCount * 1000;
        int CMCount = currentNum / 900;
        currentNum -= CMCount * 900;
        int DCount = currentNum / 500;
        currentNum -= DCount * 500;
        int CDCount = currentNum / 400;
        currentNum -= CDCount * 400;
        int CCount = currentNum / 100;
        currentNum -= CCount * 100;
        int XCCount = currentNum / 90;
        currentNum -= XCCount * 90;
        int LCount = currentNum / 50;
        currentNum -= LCount * 50;
        int XLCount = currentNum / 40;
        currentNum -= XLCount * 40;
        int XCount = currentNum / 10;
        currentNum -= XCount * 10;
        int IXCount = currentNum / 9;
        currentNum -= IXCount * 9;
        int VCount = currentNum / 5;
        currentNum -= VCount * 5;
        int IVCount = currentNum / 4;
        currentNum -= IVCount * 4;
        int ICount = currentNum;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MCount; i++){
            sb.append("M");
        }
        for (int i = 0; i < CMCount; i++){
            sb.append("CM");
        }
        for (int i = 0; i < DCount; i++){
            sb.append("D");
        }
        for (int i = 0; i < CDCount; i++){
            sb.append("CD");
        }
        for (int i = 0; i < CCount; i++){
            sb.append("C");
        }
        for (int i = 0; i < XCCount; i++){
            sb.append("XC");
        }
        for (int i = 0; i < LCount; i++){
            sb.append("L");
        }
        for (int i = 0; i < XLCount; i++){
            sb.append("XL");
        }
        for (int i = 0; i < XCount; i++){
            sb.append("X");
        }
        for (int i = 0; i < IXCount; i++){
            sb.append("IX");
        }

        for (int i = 0; i < VCount; i++){
            sb.append("V");
        }
        for (int i = 0; i < IVCount; i++){
            sb.append("IV");
        }
        for (int i = 0; i < ICount; i++){
            sb.append("I");
        }
        return sb.toString();
    }

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public String intToRoman2(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num > values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
            if (num == 0) break;
        }
        return sb.toString();
    }
}
