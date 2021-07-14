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
 * create by zhangsong 2019/1/30
 * <p>
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗
 */
public class Leet0009 {
    public static void main(String[] args) {
        Leet0009 l = new Leet0009();
        l.test();
    }

    private void test() {

        int s = 121;
        String ret = "true";
        System.out.println("----------------------");
        System.out.println(isPalindrome(s));
        System.out.println(ret);

        s = -121;
        ret = "false";
        System.out.println("----------------------");
        System.out.println(isPalindrome(s));
        System.out.println(ret);

        s = 10;
        ret = "false";
        System.out.println("----------------------");
        System.out.println(isPalindrome(s));
        System.out.println(ret);
    }


    public boolean isPalindrome2(int x) {

        //String s = String.valueOf(x);
        char[] s = (x + "").toCharArray();
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            if (s[left++] != s[right--]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(int x) {

        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int ret = 0;

        while (x > ret) {
            ret = ret * 10 + x % 10;
            x /= 10;
        }
        return ret == x || x == ret / 10;
    }

}
