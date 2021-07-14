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
 * 验证给定的字符串是否为数字。
 * <p>
 * 例如:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * <p>
 * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。
 */
public class Leet0065 {
    public static void main(String[] args) {
        Leet0065 l = new Leet0065();

        String s = "0";
        String result = "true";
        System.out.println("------------");
        System.out.println(l.isNumber(s));
        System.out.println(result);

        s = "0.1";
        result = "true";
        System.out.println("------------");
        System.out.println(l.isNumber(s));
        System.out.println(result);

        s = "abc";
        result = "false";
        System.out.println("------------");
        System.out.println(l.isNumber(s));
        System.out.println(result);

        s = "1 a";
        result = "false";
        System.out.println("------------");
        System.out.println(l.isNumber(s));
        System.out.println(result);
        s = "2e10";
        result = "true";
        System.out.println("------------");
        System.out.println(l.isNumber(s));
        System.out.println(result);
        s = "959440.94f";
        result = "false";
        System.out.println("------------");
        System.out.println(l.isNumber(s));
        System.out.println(result);

    }

    public boolean isNumber(String s) {

        for(int i=0;i<s.length();i++){

            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                continue;
            }
            if(s.charAt(i)=='.'||s.charAt(i)=='e'||s.charAt(i)==' '
            ||s.charAt(i)=='+'||s.charAt(i)=='-'){
                continue;
            }
            return false;
        }

        try {
            Double.parseDouble(s);

        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}
