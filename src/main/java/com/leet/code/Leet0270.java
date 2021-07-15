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
 * @author by zhangsong 2021/7/14
 * <p>
 * 270. 最接近的二叉搜索树值
 * 1. 题目
 * 给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
 * <p>
 * 注意：
 * 给定的目标值 target 是一个浮点数
 * 题目保证在该二叉搜索树中只会存在一个最接近目标值的数
 * <p>
 * 示例：
 * 输入: root = [4,2,5,1,3]，目标值 target = 3.714286
 * <p>
 * 4
 * / \
 * 2   5
 * / \
 * 1   3
 * 输出: 4
 * <p>
 * <p>
 * 层| 索引
 * 0 |0-4
 * 1 |1-2 , 2-5
 * 2 |3-1,4-3;5,6
 * <p>
 * 思路
 * 查找层数
 * <p>
 * 2^n +1
 * <p>
 * 1,2,4,8
 */
public class Leet0270 {

    public static void main(String[] args) {

        Leet0270 leet = new Leet0270();

        int[] root;
        int verify, result;
        double target;

        root = new int[]{4, 2, 5, 1, 3};
        target = 3.714286;
        verify = 4;

        result = leet.closestValue(root, target);
        System.out.println("===>" + verify + ";" + (result == verify) + ";" + result);


        root = new int[]{4, 2, 5, 1, 3};
        target = 2;
        verify = 2;

        result = leet.closestValue(root, target);
        System.out.println("===>" + verify + ";" + (result == verify) + ";" + result);


        root = new int[]{4, 2, 5, 1, 3};
        target = 1.6;
        verify = 2;

        result = leet.closestValue(root, target);
        System.out.println("===>" + verify + ";" + (result == verify) + ";" + result);

        root = new int[]{4, 2, 5, 1, 3};
        target = 1.4;
        verify = 1;

        result = leet.closestValue(root, target);
        System.out.println("===>" + verify + ";" + (result == verify) + ";" + result);
    }

    int closestValue(int[] root, double target) {

        int start = 0;


        int right = root.length - 1;
        int maxIndex = 0;
        double maxn = Double.MAX_VALUE;

        while (start <= right) {
            if (root[start] == target) {
                return root[start];
            }

            double m = Math.abs(root[start] - target);
            if (maxn > m) {
                maxn = m;
                maxIndex = start;
            }

            if (root[start] > target) {
                start = 2 * start + 1;
            } else {
                start = 2 * start + 2;
            }
        }

        if (maxIndex >= 0) {
            return root[maxIndex];
        }

        return -1;
    }
}
