package practice.hash;


//36 有效的数独  https://leetcode-cn.com/problems/valid-sudoku/
public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] boxes = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int index = board[i][j] - '1';
                int[] box = boxes[i / 3 * 3 + j / 3];
                if (rows[i][index] == 1 || cols[j][index] == 1 || box[index] == 1) {
                    return false;
                }
                rows[i][index] = 1;
                cols[j][index] = 1;
                box[index] = 1;
            }
        }
        return true;
    }
}
