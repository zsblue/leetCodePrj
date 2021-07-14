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
 * 374. 猜数字大小
 * 猜数字游戏的规则如下：
 * <p>
 * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 * <p>
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * 返回我选出的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10, pick = 6
 * 输出：6
 * 示例 2：
 * <p>
 * 输入：n = 1, pick = 1
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：n = 2, pick = 1
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：n = 2, pick = 2
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2^31 - 1
 * 1 <= pick <= n
 */
public class Leet0374 {

    static int pick;

    public static void main(String[] args) {
        int n, ret, result;

        Leet0374 leet = new Leet0374();
        n = 10;
        pick = 6;
        result = 6;

        ret = leet.guessNumber(n);
        System.out.println("===>" + result + ";" + (result == ret) + ";" + ret);


        n = 1;
        pick = 1;
        result = 1;
        ret = leet.guessNumber(n);
        System.out.println("===>" + result + ";" + (result == ret) + ";" + ret);

        n = 2;
        pick = 1;
        result = 1;
        ret = leet.guessNumber(n);
        System.out.println("===>" + result + ";" + (result == ret) + ";" + ret);


        n = 2;
        pick = 2;
        result = 2;
        ret = leet.guessNumber(n);
        System.out.println("===>" + result + ";" + (result == ret) + ";" + ret);
    }

    public int guessNumber(int n) {

        if (n <= 1) {
            return n;
        }
        int left = 1;
        int right = n;
        while (left < right) {

            int mid = (right - left) / 2 + left;

            int r = guess(mid);

            if (r == 0) {
                return mid;
            }
            if (r > 0) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return left;

    }

    int guess(int num) {
        if (pick == num) {
            return 0;
        }
        if (pick < num) {
            return -1;
        } else {
            return 1;
        }


    }
}
