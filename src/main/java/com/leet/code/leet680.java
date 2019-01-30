package main.java.com.leet.code;

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
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 * <p>
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000
 */
public class leet680 {

    public static void main(String[] args) {
        leet680 l = new leet680();
        System.out.println(l.validPalindrome("aba"));
        System.out.println(l.validPalindrome("abca"));
        System.out.println(l.validPalindrome("abcaa"));
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(l.validPalindrome(s));

    }

    public boolean validPalindrome(String s) {

        if (s.isEmpty()) {
            return false;
        }
        if (s.length() <= 2) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        int left1 = 0;
        int right2 = right;

        int remove = 0;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (remove == 0 && left < right && s.charAt(left + 1) == s.charAt(right)) {
                    left1 = left;
                    right2 = right;
                    left++;

                    remove++;
                    continue;
                }

                if (remove == 1) {
                    //恢复上一次不一致的位置
                    left = left1;
                    right = right2;
                }
                if (remove < 2 && left < right && s.charAt(left) == s.charAt(right - 1)) {
                    right--;
                    remove++;
                    continue;
                }

                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
