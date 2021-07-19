package com.leet.code;

import java.util.Arrays;

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
 * @author by zhangsong 2021/7/19
 * <p>
 * 1064 不动点
 * <p>
 * 题目描述：
 * 给定已经按升序排列、由不同整数组成的数组 A，返回满足 A[i] == i 的最小索引 i。如果不存在这样的 i，返回 -1。
 * <p>
 * 示例 1：
 * 输入：[-10,-5,0,3,7]
 * 输出：3
 * 解释：
 * 对于给定的数组，A[0] = -10，A[1] = -5，A[2] = 0，A[3] = 3，因此输出为 3 。
 * <p>
 * 示例 2：
 * 输入：[0,2,5,8,17]
 * 输出：0
 * 示例：
 * A[0] = 0，因此输出为 0 。
 * <p>
 * 示例 3：
 * 输入：[-10,-5,3,4,7,9]
 * 输出：-1
 * 解释：
 * 不存在这样的 i 满足 A[i] = i，因此输出为 -1 。
 * <p>
 * 提示：
 * 1 <= A.length < 10^4
 * -10^9 <= A[i] <= 10^9
 * ————————————————
 * 版权声明：本文为CSDN博主「王培琳」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_44171872/article/details/108611519
 */
public class Leet1064 {

    public static void main(String[] args) {

        Leet1064 leet = new Leet1064();
        int[] A;
        int verify, result;

        A = new int[]{-10, -5, 0, 3, 7};
        verify = 3;
        result = leet.fixedPoint(A);
        BaseLeet.check(verify, result);


        A = new int[]{0, 2, 5, 8, 17};
        verify = 0;
        result = leet.fixedPoint(A);
        BaseLeet.check(verify, result);

        A = new int[]{-10, -5, 3, 4, 7, 9};
        verify = -1;
        result = leet.fixedPoint(A);
        BaseLeet.check(verify, result);
    }

    int fixedPoint(int[] A) {

        int left = 0, right = A.length - 1;

        while (left <= right) {

            int mid = (right - left) / 2 + left;

            if (A[mid] == mid) {
                return mid;
            } else if (A[mid] < mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return -1;
    }
}
