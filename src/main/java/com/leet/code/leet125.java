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
 * 125. 验证回文串
 * <p>
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
public class leet125 {

    public static void main(String[]args){
        leet125 l = new leet125();


        String s = "A man, a plan, a canal: Panama";
        String ret = "true";
        System.out.println("----------------------");
        System.out.println(l.isPalindrome(s));
        System.out.println(ret);

        s = "race a car";
        ret = "false";
        System.out.println("----------------------");
        System.out.println(l.isPalindrome(s));
        System.out.println(ret);

        s ="0p";
        ret = "false";
        System.out.println("----------------------");
        System.out.println(l.isPalindrome(s));
        System.out.println(ret);

    }


    public boolean isPalindrome(String s) {
        s = s.toLowerCase().trim();
        if(s.isEmpty()){
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (!((s.charAt(left) <= 'z' && s.charAt(left) >= 'a')
                    ||(s.charAt(left) <= '9' && s.charAt(left) >= '0')) && left<right) {
                left++;
            }

            while (!((s.charAt(right) <= 'z' && s.charAt(right) >= 'a')
                    ||(s.charAt(right) <= '9' && s.charAt(right) >= '0'))&& right>left) {
                right--;
            }


            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
