package main.java.com.leet.code;

import java.util.ArrayList;
import java.util.List;

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
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class leet006 {

    public static void main(String[] args) {
        leet006 l = new leet006();

        String s = "LEETCODEISHIRING";
        int numRows = 3;
        String ret = "LCIRETOESIIGEDHN";
        String retResult = l.convert(s, numRows);
        System.out.println("----------------");
        System.out.println(ret);
        System.out.println(retResult);

        numRows = 4;
        ret = "LDREOEIIECIHNTSG";
        retResult = l.convert(s, numRows);
        System.out.println("----------------");
        System.out.println(ret);
        System.out.println(retResult);

        numRows = 2;
        ret = "AB";
        retResult = l.convert(s, numRows);
        System.out.println("----------------");
        System.out.println(ret);
        System.out.println(retResult);

    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.max(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int currentRow = 0;
        boolean goUp = false;
        for (int i = 0; i < s.length(); i++) {
            rows.get(currentRow).append(s.charAt(i));
            if (currentRow == numRows - 1) {
                goUp = true;
            } else if (currentRow == 0) {
                goUp = false;
            }
            if (goUp) {
                currentRow--;
            } else {
                currentRow++;
            }
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder sb : rows) {
            ret.append(sb);
        }
        return ret.toString();
    }


    /**
     *思路
     * 按照与逐行读取 Z 字形图案相同的顺序访问字符串。
     *
     * 算法
     * 首先访问 行 0 中的所有字符，接着访问 行 1，然后 行 2，依此类推...
     *
     * 对于所有整数 k，
     *     行 0 中的字符位于索引 k  (2⋅numRows−2) 处;
     *     行 numRows−1 中的字符位于索引 k  (2⋅numRows−2)+numRows−1 处;
     *     内部的 行 i 中的字符位于索引 k  (2⋅numRows−2)+i 以及 (k+1)(2⋅numRows−2)−i处;
     */
    public String convert2(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }

}
