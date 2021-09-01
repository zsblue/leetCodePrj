package com.leet.code;

/**
 * **
 * .*                   @
 * .*           @@@@     @@
 * .*        @@@    @@   @* @             /@/@@/@/@@/@/
 * .*      @@@       @@  @ * @           /@/  /@/  /@/
 * .*    @@         @@  @ * @           /@/  /@/  /@/
 * .*  @@          @@  @ * @           /@/  /@/  /@/
 * .* @@          @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 * .*  @@          @@  @ * @     @ @   \@\  \@\  \@\
 * .*    @@         @@  @ * @    @ @    \@\  \@\  \@\
 * .*      @@@       @@  @ * @  @ * @    \@\  \@\  \@\
 * .*        @@@    @@   @* @  @ * * @    \@\@@\@\@@\@\
 * .*           @@@@     @@    @@*@*@@
 * .*                   @        ***
 * **
 *
 * @author by zhangsong 2021/9/1
 * <p>
 * 1351. 统计有序矩阵中的负数
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
 * <p>
 * 请你统计并返回 grid 中 负数 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 * 示例 2：
 * <p>
 * 输入：grid = [[3,2],[1,0]]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：grid = [[1,-1],[-1,-1]]
 * 输出：3
 * 示例 4：
 * <p>
 * 输入：grid = [[-1]]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 * <p>
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(n + m) 的解决方案吗？
 */
public class Leet1351 {

    public static void main(String[] args) {

        Leet1351 leet = new Leet1351();

        int[][] grid;
        int result, verify;

        grid = new int[][]{
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}};
        verify = 8;
        result = leet.countNegatives(grid);
        BaseLeet.check(verify, result);

        grid = new int[][]{
                {3, 2}, {1, 0}};
        verify = 0;
        result = leet.countNegatives(grid);
        BaseLeet.check(verify, result);


        grid = new int[][]{
                {1, -1},
                {-1, -1}};
        verify = 3;
        result = leet.countNegatives(grid);
        BaseLeet.check(verify, result);


        grid = new int[][]{
                {-1}};
        verify = 1;
        result = leet.countNegatives(grid);
        BaseLeet.check(verify, result);

    }


    public int countNegatives2(int[][] grid) {

        int ret = 0;
        for (int m = grid.length; m < grid.length; m++) {


            int[] row = grid[m];
            int n = row.length;
            int left = 0, right = n - 1;

            while (left < right) {

                int mid = (right - left) / 2 + left;

                if (row[mid] >= 0) {
                    left++;
                } else {

                }
            }

        }
        return ret;
    }

    public int countNegatives(int[][] grid) {

        int ret = 0;
        for (int m = 0; m < grid.length; m++) {
            int[] row = grid[m];

            if (row[0] < 0) {
                ret += row.length;
                continue;
            }
            for (int n = row.length - 1; n >= 0; n--) {

                if (row[n] >= 0) {
                    ret += row.length - (n + 1);
                    break;
                }
            }
        }
        return ret;
    }
}
