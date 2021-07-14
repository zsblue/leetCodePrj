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
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 */
public class Leet0069 {


    public static void main(String[] args) {
        Leet0069 leet = new Leet0069();

        int n, ret, result;

        n = 8;
        result = 2;
        ret = leet.mySqrt(n);
        System.out.println("===>" + result + ";" + (result == ret) + ";" + ret);


        n = 9;
        result = 3;
        ret = leet.mySqrt(n);
        System.out.println("===>" + result + ";" + (result == ret) + ";" + ret);

        n = 7;
        result = 2;
        ret = leet.mySqrt(n);
        System.out.println("===>" + result + ";" + (result == ret) + ";" + ret);

        n = 2147395599;
        result = 46339;
        ret = leet.mySqrt(n);
        System.out.println("===>" + result + ";" + (result == ret) + ";" + ret);


    }

    public int mySqrt(int x) {

        int left = 1;
        int right = x;
        if (x <= 1) {
            return x;
        }

        while (left < right) {
            int mid = (right - left) / 2 + left;

            int m = x / mid;

            if (m == mid) {
                return mid;
            }
            if (m < mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
}
