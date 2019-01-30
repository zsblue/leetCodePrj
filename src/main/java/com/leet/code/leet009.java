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
 * <p>
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗
 */
public class leet009 {
    public static void main(String[] args) {
        leet009 l = new leet009();
        l.test();
    }

    private void test() {

        int s = 121;
        String ret = "true";
        System.out.println("----------------------");
        System.out.println(isPalindrome(s));
        System.out.println(ret);

        s = -121;
        ret = "false";
        System.out.println("----------------------");
        System.out.println(isPalindrome(s));
        System.out.println(ret);

        s = 10;
        ret = "false";
        System.out.println("----------------------");
        System.out.println(isPalindrome(s));
        System.out.println(ret);
    }


    public boolean isPalindrome(int x) {

        //String s = String.valueOf(x);
        char[] s= (x+"").toCharArray();
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            if (s[left++] != s[right--]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        int ret = 0;
        int temp = x;
        while (temp > 0) {
            ret = ret * 10 + temp % 10;
            temp /= 10;
        }
        return ret == x;
    }

}
