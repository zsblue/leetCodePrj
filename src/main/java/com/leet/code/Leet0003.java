package com.leet.code;

import java.util.HashMap;

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
 * create by zhangsong 2019/1/28
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Leet0003 {

    public static void main(String[] args) {

        int max = 0;
        Leet0003 l = new Leet0003();

        String s = "dvdf";
        max = l.lengthOfLongestSubstring(s);
        System.out.println("===========");
        System.out.println("input:" + s);
        System.out.println("output:" + max);

        s = "bbbbb";
        max = l.lengthOfLongestSubstring(s);
        System.out.println("===========");
        System.out.println("input:" + s);
        System.out.println("output:" + max);
        s = "pwwkew";
        max = l.lengthOfLongestSubstring(s);
        System.out.println("===========");
        System.out.println("input:" + s);
        System.out.println("output:" + max);

        s = " ";
        max = l.lengthOfLongestSubstring(s);
        System.out.println("===========");
        System.out.println("input:" + s);
        System.out.println("output:" + max);


    }

    public int lengthOfLongestSubstring(String s) {

        //最左字符位置
        int left = 0;
        //最右字符位置
        int right;
        //最大长度
        int max = 0;
        for (right = 0; right < s.length(); right++) {
            //最右边字符
            char f = s.charAt(right);
            for (int index = left; index < right; index++) {
                if (f == s.charAt(index)) {
                    max = max < right - left ? right - left : max;
                    left = index + 1;
                    break;
                }
            }
        }

        max = max < right - left ? right - left : max;
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {

        HashMap<Character, Integer> hash = new HashMap();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char f = s.charAt(i);
            if (hash.containsKey(f)) {

                if (max < hash.keySet().size()) {
                    max = hash.keySet().size();
                }
                i = hash.get(f);
                hash.clear();
                continue;
            }
            hash.put(f, i);
        }

        if (max < hash.keySet().size()) {
            max = hash.keySet().size();
        }

        return max;
    }
}
