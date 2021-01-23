//37 解数独 https://leetcode-cn.com/problems/sudoku-solver/#/description
public class SolveSudoku {

    public static void main(String[] args) {
        int num = 1;
        char a = (char) num;
        char b = '2';
        System.out.println(a);
    }

    public void solveSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] boxes = new int[9][9];

        //初始化，在数独的每行，列，块中有哪些数已经被填
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else {
                    int index = board[i][j] - '1';
                    int[] box = boxes[i / 3 * 3 + j / 3];
                    rows[i][index] = 1;
                    cols[j][index] = 1;
                    box[index] = 1;
                }
            }
        }
        //fill it
        fillit(board, rows, cols, boxes, 0, 0);
    }

    private boolean fillit(char[][] board, int[][] rows, int[][] cols, int[][] boxes, int row, int col) {
        //列到头了就换行
        if (col > 8) {
            col = 0;
            row++;
        }

        if (row > 8) return true;

        if (board[row][col] != '.') {
            return fillit(board, rows, cols, boxes, row, col + 1);
        }

        //从 1 到 9 逐个回溯
        for (char i = '1'; i <= '9'; i++) {
            int[] box = boxes[row / 3 * 3 + col / 3];
            int index = i - '1';
            if (rows[row][index] == 1 || cols[col][index] == 1 || box[index] == 1) {
                continue;
            } else {
                board[row][col] = i;
                rows[row][index] = 1;
                cols[col][index] = 1;
                box[index] = 1;
                if(fillit(board, rows, cols, boxes, row, col + 1)) return true;
                else {
                    board[row][col] = '.';
                    rows[row][index] = 0;
                    cols[col][index] = 0;
                    box[index] = 0;
                }
            }
        }
        return false;
    }
}
