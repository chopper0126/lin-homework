package backtracing;

public class NO37 {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    private boolean solveSudokuHelper(char[][] board) {
        //一个for循环遍历期盼的行，一个遍历列
        //再判断这个位置放9个数的可能性
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;//因为都是从零开始，所以要跳过原始数字
                }
                //单层逻辑
                for (char k = '1'; k <= '9'; k++) {
                    if (isValidSudu(i, j, k, board)) {
                        board[i][j] = k;
                        if (solveSudokuHelper(board)) {
                            return true;//如果找到一条路径就返回
                        }
                        board[i][j] = '.';
                    }
                }
                //如果1-9都不行，就返回false
                return false;
            }
        }
        return true;
    }

    /*
     *
     *
     *@author chopper
     *@date 2022/10/27 16:47
     * @param row: 行
     * @param col: 列
     * @param val: val
     * @param board: 棋盘
     *return boolean
     */
    private boolean isValidSudu(int row, int col, char val, char[][] board) {
        // 同行是否重复
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }
        // 同列是否重复
        for (int j = 0; j < 9; j++) {
            if (board[j][col] == val) {
                return false;
            }
        }
        // 9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }


}
