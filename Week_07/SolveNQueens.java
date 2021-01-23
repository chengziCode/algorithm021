import java.util.ArrayList;
import java.util.List;

// 51 N皇后   https://leetcode-cn.com/problems/n-queens/
public class SolveNQueens {

    public static void main(String[] args) {
        System.out.println(new SolveNQueens().solveNQueens(4));
    }

    List<List<String>> resList = new ArrayList<>();
    int[] cols;
    int[] leftX;
    int[] rightX;

    /**
     * 回溯法
     * <p>
     * 1 每列， 对角线不能同时存在2个皇后。
     * 通过数组对每个节点hash到每列，对角线，
     * 这里只需要一维数组，不同于数独要映射9个数，这里只需要映射一整列，对角线
     * <p>
     * 2 针对每个格子进行回溯
     * 3 满足条件加入到结果集，再回溯清除当前状态，因为可能存在多个解
     */
    public List<List<String>> solveNQueens(int n) {
        if (n == 0) return resList;
        cols = new int[n];
        leftX = new int[2 * n - 1];
        rightX = new int[2 * n - 1];

        List<Integer> curFlag = new ArrayList<>();
        dfs(n, 0, curFlag);
        return resList;
    }

    private void dfs(int n, int row, List<Integer> curFlag) {
        if (row == n) {// 填完,记录结果并返回
            resList.add(arrayToString(curFlag, n));
            return;
        }
        //对每个格子进行回溯
        for (int i = 0; i < n; i++) {
            if (cols[i] == 0 && leftX[row + i] == 0 && rightX[row - i + n - 1] == 0) { //[row - i]下标可能为负数，加上n - 1凑0
                curFlag.add(i);
                cols[i] = 1;
                leftX[row + i] = 1;
                rightX[row - i + n - 1] = 1;

                dfs(n, row + 1, curFlag);

                curFlag.remove(curFlag.size() - 1);
                cols[i] = 0;
                leftX[row + i] = 0;
                rightX[row - i + n - 1] = 0;
            }else continue;

        }
    }

    /**
     * 数组到列表的格式化
     *
     * @param curFlag
     * @param n
     * @return
     */
    private List<String> arrayToString(List<Integer> curFlag, int n) {
        List<String> lst = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(".");
        for (int numFlag : curFlag) {
            StringBuilder cpSb = new StringBuilder(sb);
            String str = cpSb.replace(numFlag, numFlag + 1, "Q").toString();
            lst.add(str);
        }
        return lst;
    }
}
