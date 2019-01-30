package main.java.com.leet.code;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.HashMap;
import java.util.Map;

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
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
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
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "III"
 * 输出: 3
 * <p>
 * 示例 2:
 * <p>
 * 输入: "IV"
 * 输出: 4
 * <p>
 * 示例 3:
 * <p>
 * 输入: "IX"
 * 输出: 9
 * <p>
 * 示例 4:
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * <p>
 * 示例 5:
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class leet013 {


    public static void main(String[] args) {
        leet013 l = new leet013();
        l.test();
    }

    private void test() {

        String s = "III";
        String ret = "3";
        System.out.println("----------------------");
        System.out.println(romanToInt(s));
        System.out.println(ret);

        s = "IV";
        ret = "4";
        System.out.println("----------------------");
        System.out.println(romanToInt(s));
        System.out.println(ret);

        s = "IX";
        ret = "9";
        System.out.println("----------------------");
        System.out.println(romanToInt(s));
        System.out.println(ret);

        s = "LVIII";
        ret = "58";
        System.out.println("----------------------");
        System.out.println(romanToInt(s));
        System.out.println(ret);

        s = "MCMXCIV";
        ret = "1994";
        System.out.println("----------------------");
        System.out.println(romanToInt(s));
        System.out.println(ret);
    }

    String[][] K = new String[][]{{"I", "V"}, {"X", "L"}, {"C", "D"}, {"M", ""}};

    public int romanToInt2(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int ret = 0;


        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 4; j++) {
                String s1 = String.valueOf(s.charAt(i));
                int temp = (int) Math.pow(10, j);
                if (s1.equals(K[j][0])) {
                    if (i < s.length() - 1) {
                        int next = i + 1;
                        String s2 = String.valueOf(s.charAt(next));
                        if (s2.equals(K[j][1])) {
                            temp = temp * -1 + (int) Math.pow(10, j) * 5;
                            i = next;
                        } else if (j + 1 < K.length && s2.equals(K[j + 1][0])) {
                            temp = temp * -1 + (int) Math.pow(10, j + 1);
                            i = next;
                        }
                    }
                } else if (s1.equals(K[j][1])) {
                    temp *= 5;
                } else {
                    continue;
                }
                ret += temp;
                break;
            }
        }


        return ret;

    }

    static Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int sum = 0;
        int i=0;
        int len = s.length()-1;
        for (; i < s.length() ; ++i) {
            if (i<len && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                sum -= map.get(s.charAt(i));
                sum += map.get(s.charAt(i + 1));
                i++;
            } else {
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }


}
