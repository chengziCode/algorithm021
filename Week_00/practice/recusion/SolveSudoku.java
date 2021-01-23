package practice.recusion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//37 解数独 https://leetcode-cn.com/problems/sudoku-solver/#/description
public class SolveSudoku {

    public static void main(String[] args) {
        int num = 1;
        char a = (char) num;
        char b = '2';
        System.out.println(a);
    }

    public void solveSudoku(char[][] board) {
        //记录每行，列，块中被填的数据
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
        //填满了
        if (row > 8) return true;

        //不为空，下一个
        if (board[row][col] != '.') {
            return fillit(board, rows, cols, boxes, row, col + 1);
        }

        //从 1 到 9 逐个回溯
        for (char i = '1'; i <= '9'; i++) {
            int[] box = boxes[row / 3 * 3 + col / 3]; //计算块的索引
            int index = i - '1'; // hash
            if (rows[row][index] == 1 || cols[col][index] == 1 || box[index] == 1) { //判断每 行，列，块中是否已经被填
                continue;
            } else {
                board[row][col] = i;
                rows[row][index] = 1;
                cols[col][index] = 1;
                box[index] = 1;
                if(fillit(board, rows, cols, boxes, row, col + 1)) return true;
                else {//回溯当前层操作
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
