package com.leet.code;

import java.lang.reflect.Method;

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
 * create by zhangsong 2019/2/11
 */
public class BaseLeet {
    public static void leetRun(Class cls, String methodName,  Object[]  pars ) {

        try {


            Class[] parsType = new Class[pars.length];
            for (int i = 0; i < pars.length; i++) {

                parsType[i] = pars[i].getClass();
            }

            Method m = cls.getMethod(methodName, parsType);
            //getMethod()方法的第一个参数为要取得的对象名称，后面为参数类型的类
            ListNode ret = (ListNode) m.invoke(cls.newInstance(), pars);

            ret.out();
        } catch (Exception ex) {

            System.out.println(ex);
        }
    }
}
