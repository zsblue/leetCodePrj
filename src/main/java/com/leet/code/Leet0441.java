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
 * 441. 排列硬币
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * <p>
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * <p>
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 * <p>
 * 示例 1:
 * <p>
 * n = 5
 * <p>
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * <p>
 * 因为第三行不完整，所以返回2.
 * 示例 2:
 * <p>
 * n = 8
 * <p>
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * <p>
 * 因为第四行不完整，所以返回3.
 */
public class Leet0441 {

    public static void main(String[] args) {
        Leet0441 leet = new Leet0441();

        int result, n, verify;

        n = 5;
        verify = 2;
        result = leet.arrangeCoins(n);
        System.out.println(n + "===>" + result + ";" + verify);

        n = 8;
        verify = 3;
        result = leet.arrangeCoins(n);
        System.out.println(n + "===>" + result + ";" + verify);


        n = 1;
        verify = 1;
        result = leet.arrangeCoins(n);
        System.out.println(n + "===>" + result + ";" + verify);

        n = 3;
        verify = 2;
        result = leet.arrangeCoins(n);
        System.out.println(n + "===>" + result + ";" + verify);
        n = 10;
        verify = 4;
        result = leet.arrangeCoins(n);
        System.out.println(n + "===>" + result + ";" + verify);

        n = 1804289383;
        verify = 60070;
        result = leet.arrangeCoins(n);
        System.out.println(n + "===>" + result + ";" + verify);
    }

    public int arrangeCoins2(int n) {

        if (n < 2) {
            return 1;
        }
        int s = n;
        int start = 1;
        while (start <= s) {
            s -= start;
            start++;
        }
        return start - 1;

    }

    public int arrangeCoins(int n) {
        if (n < 2) {
            return 1;
        }
        int left = 1, right = n / 2 + 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            double ss = ((double) n) / mid * 2 - 1;
            if (ss == mid) {
                return mid;
            } else if (ss > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

}
