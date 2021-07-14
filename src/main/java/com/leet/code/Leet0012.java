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
 * create by zhangsong 2019/1/29
 * <p>
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * <p>
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: "III"
 * <p>
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "IV"
 * <p>
 * 示例 3:
 * <p>
 * 输入: 9
 * 输出: "IX"
 * <p>
 * 示例 4:
 * <p>
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * <p>
 * 示例 5:
 * <p>
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class Leet0012 {

    public static void main(String[] args) {
        Leet0012 l = new Leet0012();

        int s = 3;
        String result = "III";
        System.out.println("------------");
        System.out.println(l.intToRoman(s));
        System.out.println(result);

        s = 4;
        result = "IV";
        System.out.println("------------");
        System.out.println(l.intToRoman(s));
        System.out.println(result);

        s = 9;
        result = "IX";
        System.out.println("------------");
        System.out.println(l.intToRoman(s));
        System.out.println(result);

        s = 58;
        result = "LVIII";
        System.out.println("------------");
        System.out.println(l.intToRoman(s));
        System.out.println(result);
        s = 1994;
        result = "MCMXCIV";
        System.out.println("------------");
        System.out.println(l.intToRoman(s));
        System.out.println(result);

        s = 10;
        result = "X";
        System.out.println("------------");
        System.out.println(l.intToRoman(s));
        System.out.println(result);

    }


    public String intToRoman(int num) {

        if (num < 1 || num > 3999) {
            return "";
        }
        String[][] K = new String[][]{{"I", "V"}, {"X", "L"}, {"C", "D"}, {"M", ""}};
        StringBuilder sb = new StringBuilder();

        int b = 0;
        while (b < 4 && num > 0) {
            int m = num % 10;
            num = num / 10;
            b++;

            if(m==0){
                continue;
            }

            int currentIndex = b-1;

            int m2 = m % 5;
            int m3 = m / 5;

            StringBuilder temp = new StringBuilder();
            if (m2 >= 1 && m2 <= 3) {
                if (m3 > 0) {
                    temp.append(K[currentIndex][1]);
                }
                for (int i = 0; i < m2; i++) {
                    temp.append(K[currentIndex][0]);
                }
            }
            if (m2 == 0) {
                temp.append(K[currentIndex][1]);
            }
            if (m2 == 4) {
                if (m3 > 0) {
                    temp.append(K[currentIndex][0]).append(K[currentIndex + 1][0]);
                } else {
                    temp.append(K[currentIndex][0]).append(K[currentIndex][1]);
                }
            }
            sb.insert(0, temp);
        }
        return sb.toString();
    }
}
