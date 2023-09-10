package backtracing;
/*
# 思路
        首先来看一下皇后们的约束条件：
        1. 不能同行
        2. 不能同列
        3. 不能同斜线
        # 回溯三部曲
            递归函数参数
                n—棋盘大小，row记录当前遍历到第几层，res—全局二维变量，存储结果，chessboard —棋盘，二维数组
            终止条件
                当到叶子结点就可以收割结果了，row == n
            单层逻辑

                ```Java
                for (int col = 0;col < n; ++col) {//++col ?
                if (isValid (row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                backTrack(n, row+1, chessboard);
                chessboard[row][col] = '.';
                }
                }

                ```

                是否合理函数

                ```Java
        public boolean isValid(int row, int col, int n, char[][] chessboard) {
                // 检查列
                for (int i=0; i<row; ++i) { // 相当于剪枝
                if (chessboard[i][col] == 'Q') {
                return false;
                }
                }

                // 检查45度对角线
                for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
                if (chessboard[i][j] == 'Q') {
                return false;
                }
                }

                // 检查135度对角线
                for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
                if (chessboard[i][j] == 'Q') {
                return false;
                }
                }
                return true;
                }
            ```
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NO51 {
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        //思路，先将棋盘填满 "."
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backTrack(n, 0, chessboard);
        return res;
    }

    private void backTrack(int n, int row, char[][] chessboard) {
        //终止条件
        // 当到叶子结点就可以收割结果了，row == n
        if (row == n) {
            //添加--一行，类型是list
            res.add(charToString(chessboard));

            return;
        }
        //单层逻辑
        for (int col = 0; col < n; ++col) {//++col ?
            if (isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                backTrack(n, row + 1, chessboard);//回溯
                chessboard[row][col] = '.';
            }
        }
    }

    private List<String> charToString(char[][] chessboard) {
        List<String > list = new ArrayList<>();
        for (char[] c : chessboard){
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    private boolean isValid(int row, int col, int n, char[][] chessboard) {
        //剪枝
        // 检查列
        for (int i = 0; i < row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

}
