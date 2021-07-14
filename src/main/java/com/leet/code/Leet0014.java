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
 * @author by zhangsong 2020/8/21
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet0014 {


    public static void main(String[] args) {

        Leet0014 leet = new Leet0014();

        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println("result:" + leet.longestCommonPrefix(strs));

        strs = new String[]{"dog", "racecar", "car"};
        System.out.println("result:" + leet.longestCommonPrefix(strs));
        strs = new String[]{};
        System.out.println("result:" + leet.longestCommonPrefix(strs));
        strs = new String[]{"a"};
        System.out.println("result:" + leet.longestCommonPrefix(strs));
        strs = new String[]{"c", "c"};
        System.out.println("result:" + leet.longestCommonPrefix(strs));
        strs = new String[]{"", ""};
        System.out.println("result:" + leet.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix2(String[] strs) {


        if (strs.length <= 0) {
            return "";
        }

        String f = strs[0];
        int fIndex = f.length();

        for (int i = 1; i < strs.length; i++) {
            String item = strs[i];
            fIndex = fIndex > item.length() ? item.length() : fIndex;

            while (fIndex > 0) {


                if (f.substring(0, fIndex).equals(item.substring(0, fIndex))) {
                    break;
                }
                fIndex--;
            }
        }

        return fIndex < 0 ? "" : f.substring(0, fIndex);
    }

    public String longestCommonPrefix(String[] strs) {


        if (strs.length <= 0) {
            return "";
        }

        String f = strs[0];
        int fIndex = f.length();

        for (int i = 1; i < strs.length; i++) {

            int le = fIndex > strs[i].length() ? strs[i].length() : fIndex;
            for (int j = 0; j < le; j++) {

                if (f.charAt(j) == strs[i].charAt(j)) {
                    continue;
                }
                fIndex = j;
                break;
            }
            if (fIndex < 0) {
                break;
            }
        }

        return fIndex < 0 ? "" : f.substring(0, fIndex + 1);
    }
}

