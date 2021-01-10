package practice.dynamicprogram;


/**
 * 62 不同路径  https://leetcode-cn.com/problems/unique-paths/
 */
public class UniquePaths {


    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3, 7));
    }
    public int uniquePaths(int m, int n) {
        /**
         * 3种解法：
         * 1 每个方块表示到finish点的路径数。  就可以构造一个二维数组， 那么start方块处对应的数字就是总的路径数。
         * 2 每个方块表示从Start到该处的路径数， 那么finish方块处对应的数字就是总的路径数
         */

        //解法1
        //初始化数组
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) arr[i][n - 1] = 1;
        for (int j = 0; j < n ;j++) arr[m - 1][j] = 1;

        for (int i = m - 2; i >= 0 ; i--)
            for (int j = n - 2; j >= 0 ; j--)
                arr[i][j] = arr[i][j + 1] + arr[i + 1][j];
        return arr[0][0];

    }
}
