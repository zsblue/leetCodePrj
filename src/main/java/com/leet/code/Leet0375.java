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
 * 375. 猜数字大小 II
 * 我们正在玩一个猜数游戏，游戏规则如下：
 * <p>
 * 我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。
 * <p>
 * 每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。
 * <p>
 * 然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。
 * <p>
 * 示例:
 * <p>
 * n = 10, 我选择了8.
 * <p>
 * 第一轮: 你猜我选择的数字是5，我会告诉你，我的数字更大一些，然后你需要支付5块。
 * 第二轮: 你猜是7，我告诉你，我的数字更大一些，你支付7块。
 * 第三轮: 你猜是9，我告诉你，我的数字更小一些，你支付9块。
 * <p>
 * 游戏结束。8 就是我选的数字。
 * <p>
 * 你最终要支付 5 + 7 + 9 = 21 块钱。
 * 给定 n ≥ 1，计算你至少需要拥有多少现金才能确保你能赢得这个游戏。
 *
 * 没有输入参数，无法处理
 */
public class Leet0375 {


    static int pick;

    public static void main(String[] args) {

        Leet0375 leet = new Leet0375();
        int n, ret, result;

        n = 10;

        ret = leet.getMoneyAmount(n);

        System.out.println(ret);

    }

    public int getMoneyAmount(int n) {

        int money = 0;
        int left = 1;
        int right = n;

        if (n <= 1) {
            return money;
        }

        while (left < right) {

            int mid = (right - left) / 2 + left;


            money += mid;

            left = mid + 1;

        }

        return money;
    }


}