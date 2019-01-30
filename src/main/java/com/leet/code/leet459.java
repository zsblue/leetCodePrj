package main.java.com.leet.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
 * create by zhangsong 2019/1/25
 * <p>
 * repeated-substring-pattern/
 * 重复字符串
 */
public class leet459 {

    public static void main(String[]args){
        testDup();
    }

    public static Boolean repeatedSubstringPattern(String cs) {

        if(cs.length()<2){
            return false;
        }
        if (cs.length() > 10000) {
            return false;
        }
        int i = 0;
//        int len = cs.length() / 2;
        int currentIndex = 0;
        String nextStr = "";

        boolean isequl = false;
        while (i <= cs.length()) {
            i++;
            if (cs.length() % i != 0) {
                continue;
            }
            nextStr = cs.substring(0, i);
            currentIndex = i;
            isequl = false;

            while (currentIndex < cs.length()) {

                if (nextStr.equals(cs.substring(currentIndex, currentIndex + i))) {
                    currentIndex += i;
                    isequl = true;
                    continue;
                }
                isequl = false;
                break;
            }
            if (isequl) {
                break;
            }
        }
//        System.out.println("========================");
//        System.out.println(isequl + ":" + currentIndex + ":" + nextStr);
//        System.out.println("========================");
        return isequl;
    }

    public static void testDup() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String cs = null;

            System.out.println("Enter your value:");
            cs = br.readLine();
            System.out.println("your value is :" + cs);

            while (!"quit".equals(cs)) {

//                System.out.println(r2(cs));
                System.out.println(repeatedSubstringPattern(cs));
                cs = br.readLine();
            }
            System.out.println("Bye Bye!");

        } catch (IOException ex) {
            System.out.println(ex);
        }


    }

    public static boolean r2(String s) {
        return (s + s).substring(1, 2 * s.length() - 1).contains(s);
    }
}
