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
 * 744. 寻找比目标字母大的最小字母
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * <p>
 * 在比较时，字母是依序循环出现的。举个例子：
 * <p>
 * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "c"
 * 输出: "f"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "d"
 * 输出: "f"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "g"
 * 输出: "j"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "j"
 * 输出: "c"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "k"
 * 输出: "c"
 * <p>
 * <p>
 * 提示：
 * <p>
 * letters长度范围在[2, 10000]区间内。
 * letters 仅由小写字母组成，最少包含两个不同的字母。
 * 目标字母target 是一个小写字母。
 */
public class Leet0744 {


    public static void main(String[] args) {
        Leet0744 leet = new Leet0744();

        char[] letters;
        char target, result, verify;

        letters = new char[]{'c', 'f', 'j'};

        target = 'a';
        verify = 'c';
        result = leet.nextGreatestLetter(letters, target);
        System.out.println("===>" + result + ";" + verify + ";" + (result == verify));

        target = 'c';
        verify = 'f';
        result = leet.nextGreatestLetter(letters, target);
        System.out.println("===>" + result + ";" + verify + ";" + (result == verify));


        target = 'd';
        verify = 'f';
        result = leet.nextGreatestLetter(letters, target);
        System.out.println("===>" + result + ";" + verify + ";" + (result == verify));


        target = 'g';
        verify = 'j';
        result = leet.nextGreatestLetter(letters, target);
        System.out.println("===>" + result + ";" + verify + ";" + (result == verify));


        target = 'j';
        verify = 'c';
        result = leet.nextGreatestLetter(letters, target);
        System.out.println("===>" + result + ";" + verify + ";" + (result == verify));


        target = 'k';
        verify = 'c';
        result = leet.nextGreatestLetter(letters, target);
        System.out.println("===>" + result + ";" + verify + ";" + (result == verify));

    }

    public char nextGreatestLetter2(char[] letters, char target) {

        if (letters.length == 1) {
            return letters[0];
        }
        if (target >= letters[letters.length - 1]) {
            return letters[0];
        }
        if (target < letters[0]) {
            return letters[0];
        }

        int left = 0, right = letters.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (target >= letters[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int index = left;

        if (left >= letters.length || left <= 0) {
            index = 0;
        } else if (letters[left] <= target) {
            index = left + 1;
        }
        return letters[index];

    }

    public char nextGreatestLetter(char[] letters, char target) {

        if (letters.length == 1) {
            return letters[0];
        }
        if (target >= letters[letters.length - 1]) {
            return letters[0];
        }
        if (target < letters[0]) {
            return letters[0];
        }

        for (int i = 0; i < letters.length; i++) {
            if (target < letters[i]) {
                return letters[i];
            }
        }
        return letters[0];
    }


}
