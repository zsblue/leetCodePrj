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
 * create by zhangsong 2019/2/14
 */
public class Leet0007 {

    public static void main(String[] args) {

        String a =new String ("1"+"2");



//        Leet0007 leet = new Leet0007();
//        System.out.println(leet.reverse(-1));
//        System.out.println(leet.reverse(1534236469));
//        System.out.println(leet.reverse(-10));
//        System.out.println(leet.reverse(10));

    }

    public int reverse(int x) {
        if (x < 10 && x > -10) {
            return x;
        }
        int temp = Math.abs(x);
        long y = 0;
        while (temp > 0) {
            y = y * 10 + temp % 10;
            temp = temp / 10;
        }
        if (x < 0) {
            y = -1 * y;
        }

        if (y > Integer.MAX_VALUE) {
            return 0;
        }
        if (y < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) y;
    }
}
