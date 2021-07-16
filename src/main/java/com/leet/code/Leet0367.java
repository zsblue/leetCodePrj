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
 * @author by zhangsong 2021/7/16
 * <p>
 * 367. 有效的完全平方数
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * <p>
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 16
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：num = 14
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 2^31 - 1
 */
public class Leet0367 {


    public static void main(String[] args) {
        Leet0367 leet = new Leet0367();

        boolean result, verify;
        int num = 16;

        result = leet.isPerfectSquare(num);
        System.out.println(num + "===>" + Math.sqrt(num) + ";" + result);


        num = 14;
        verify = false;
        result = leet.isPerfectSquare(num);

        System.out.println(num + "===>" + Math.sqrt(num) + ";" + result);


        num = 1;
        verify = true;
        result = leet.isPerfectSquare(num);
        System.out.println(num + "===>" + Math.sqrt(num) + ";" + result);

        num = 5;
        verify = false;
        result = leet.isPerfectSquare(num);
        System.out.println(num + "===>" + Math.sqrt(num) + ";" + result);

        num = 808201;
        verify = false;
        result = leet.isPerfectSquare(num);
        System.out.println(num + "===>" + Math.sqrt(num) + ";" + result);

        num = 2147395600;
        verify = false;
        result = leet.isPerfectSquare(num);
        System.out.println(num + "===>" + Math.sqrt(num) + ";" + result);


    }

    public boolean isPerfectSquare(int num) {

        if (num < 2) {
            return true;
        }
        int left = 0, right = num / 2 + 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            double r = ((double) num) / mid;
            if (r == mid) {
                return true;
            } else if (r > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

}
