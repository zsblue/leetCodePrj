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
 * create by zhangsong 2019/1/28
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class leet005 {

    public static void main(String[] args) {

        leet005 l = new leet005();
        String s = "babab";
        System.out.println(s + "-->" + l.longestPalindrome(s));
        s = "cbbd";
        System.out.println(s + "-->" + l.longestPalindrome(s));
        s = "ac";
        System.out.println(s + "-->" + l.longestPalindrome(s));
        s = "bb";
        System.out.println(s + "-->" + l.longestPalindrome(s));

    }

    public String longestPalindrome(String s) {

        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            int len1 = getMax2(s, i, i);
            int len2 = getMax2(s, i, i + 1);
            int max = Math.max(len1, len2);

            if (max > end - start) {
                start = i - (max - 1) / 2;
                end = i + (max) / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private String getMax(int mid, int left, int right, String s, int max, String ret, boolean moveleft) {

        while (left > 0 && right < s.length() - 1) {

            if (mid == right && s.charAt(mid) == s.charAt(right + 1)) {
                right++;
            } else if (mid == left && s.charAt(mid) == s.charAt(left - 1)) {
                left--;
            } else {
                left--;
                right++;
                if (s.charAt(left) != s.charAt(right)) {
                    if (moveleft) {
                        ret = getMax(mid - 1, mid - 1, mid - 1, s, max, ret, true);
                    } else {
                        ret = getMax(mid + 1, mid + 1, mid + 1, s, max, ret, false);
                    }
                    continue;
                }
            }

            if (max < right - left + 1) {
                max = right - left + 1;
                ret = s.substring(left, right + 1);
            }

        }
        return ret;
    }

    private int getMax2(String s, int left, int right) {
        while (left >= 0 && right < s.length()&& s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}
