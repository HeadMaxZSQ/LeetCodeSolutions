import java.util.HashMap;

/**
 * 36.有效的数独
 */
public class Question36 {

    /**
     * 【最优解】题解看的，仅遍历一次，非常巧妙。
     * 用2个二维数组和1个三维数组来记录数字的出现情况。
     */
    public boolean isValidSudoku(char[][] board) {
        //第一维表示行号0~8，第二维表示数字1~9的出现次数。
        int[][] rows = new int[9][9];
        //第一维表示列号0~8，第二维表示数字1~9的出现次数。
        int[][] columns = new int[9][9];
        //board共可划分为3x3个3x3方块，第一维表示方块的行号0~2，第二维表示方块的列号0~2，第三维表示数字1~9的出现次数。
        int[][][] subboxes = new int[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                //如果发现数字
                if (ch != '.') {
                    int index = ch - '0' - 1;
                    //三个数组都在对应的位置进行自增
                    rows[i][index]++;
                    columns[j][index]++;
                    subboxes[i / 3][j / 3][index]++;
                    //判断自增后的位置是否已经出现次数大于1
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }


    /**
     * 【自己想的暴力方法】直接遍历3次，分别判断每行、每列、每个3x3方格是否符合条件。
     * 每次不断重置并使用HashMap来判断数字的重复性。
     */
    public boolean isValidSudoku2(char[][] board) {
        HashMap<Character, Boolean> judgeMap = new HashMap<>();
        resetJudgeMap(judgeMap);

        //判断所有行
        for (int i = 0; i < board.length; i++) {
            //重置HashMap
            resetJudgeMap(judgeMap);
            //遍历当前行所有元素
            for (int j = 0; j < board[i].length; j++) {
                char ch = board[i][j];
                if (judgeMap.containsKey(ch)) {
                    if (judgeMap.get(ch)) {
                        return false;
                    }
                    judgeMap.put(ch, true);
                }
            }
        }

        //判断所有列
        for (int i = 0; i < board[0].length; i++) {
            //重置HashMap
            resetJudgeMap(judgeMap);
            //遍历当前列所有元素
            for (int j = 0; j < board.length; j++) {
                char ch = board[j][i];
                if (judgeMap.containsKey(ch)) {
                    if (judgeMap.get(ch)) {
                        return false;
                    }
                    judgeMap.put(ch, true);
                }
            }
        }

        //判断所有方格
        for (int i = 0; i < board.length; i = i + 3) {
            for (int j = 0; j < board[0].length; j = j + 3) {
                //重置HashMap
                resetJudgeMap(judgeMap);
                //遍历当前方格中的所有元素
                for (int m = i; m < i + 3; m++) {
                    for (int n = j; n < j + 3; n++) {
                        char ch = board[m][n];
                        if (judgeMap.containsKey(ch)) {
                            if (judgeMap.get(ch)) {
                                return false;
                            }
                            judgeMap.put(ch, true);
                        }
                    }
                }
            }
        }
        return true;
    }

    //重置用于判断重复的HashMap，key表示数字，value表示是否已经存在该数字。
    private void resetJudgeMap(HashMap<Character, Boolean> judgeMap) {
        judgeMap.clear();
        for (int i = 1; i <= 9; i++) {
            judgeMap.put((char) ('1' + i - 1), false);
        }
    }
}
