package com.leet.code;

import java.io.*;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Random;

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
 * create by zhangsong 2019/2/20
 * <p>
 * <p>
 * 随机生成 Salary {name, baseSalary, bonus  }的记录，如“wxxx,10,1”，每行一条记录，总共1000万记录，写入文本文件（UFT-8编码），
 *    然后读取文件，name的前两个字符相同的，其年薪累加，比如wx，100万，3个人，最后做排序和分组，输出年薪总额最高的10组：
 *          wx, 200万，10人
 *          lt, 180万，8人
 *          ....
 * name 4位a-z随机，    baseSalary [0,100]随机 bonus[0-5]随机 年薪总额 = baseSalary*13 + bonus
 *  
 * 请努力将程序优化到5秒内执行完
 */
public class Other001 {
    public static void main(String[] args) throws IOException {

        Other001 other = new Other001();

//        Long l1 = new Date().getTime();
//        String fileName = "a" + l1.toString();
//        System.out.println("s:" + l1);
//        other.Generate(fileName);
//        Long l2 = new Date().getTime();
//        System.out.println("e:" + l2);
//        System.out.println("e:" + (l2 - l1));
////
//         l1 = new Date().getTime();
//         fileName = "b" + l1.toString();
//        System.out.println("s:" + l1);
//        other.Generate2(fileName);
//         l2 = new Date().getTime();
//        System.out.println("e:" + l2);
//        System.out.println("e:" + (l2 - l1));


//        other.Calc("a1550656917703");
        other.Calc("a1550659164179");


    }

    String split = ",";
    String end = "\r\n";

    public void Generate(String fileName) throws IOException {


        int size = 1000*10000;
        size=1000;

        File f = new File(fileName);

        if (f.exists()) {
            f.delete();
            f.createNewFile();
        }
        FileWriter fw = new FileWriter(f);

        Random r = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            int n = r.nextInt(100);
            byte name = (byte) (n % 26);
            if (name <= 0) {
                name *= -1;
            }
            char name1, name2, name3, name4;
            name1 = 'a';
            name1 += name;
            name2 = name3 = name4 = name1;
            name2 += 1;
            name3 += 2;
            name4 += 3;

            if (name2 > 'z') {
                name2 -= 26;
            }
            if (name3 > 'z') {
                name3 -= 26;
            }
            if (name4 > 'z') {
                name4 -= 26;
            }


            int baseSalary = n % 100;
            int bonus = n % 5;


            sb.append(name1).append(name2).append(name3).append(name4)
                    .append(split).append(baseSalary)
                    .append(split).append(bonus).append(end);

            if ((i + 1) % 500 == 0) {
                fw.write(sb.toString(), 0, sb.length());
                fw.flush();
                sb = new StringBuilder();
            }

        }
        if (sb.length() > 0) {
            fw.write(sb.toString(), 0, sb.length());
            fw.flush();
        }
        fw.close();

    }

    public void Calc(String fileName) throws IOException {

        // name, salary,count,
        HashMap<String, HashMap<Integer, Integer>> temp = new HashMap<>(512);

        File f = new File(fileName);
        if (!f.exists()) {
            throw new IOException("not found file :" + fileName);
        }
        FileReader fr = new FileReader(f);

        char[] buffer = new char[1024 * 4];


        int next = 0;
        StringBuffer name = new StringBuffer();
        StringBuffer salaryBase = new StringBuffer();
        StringBuffer bound = new StringBuffer();
        int pageIndex =0;
        while (fr.read(buffer) != -1) {
            pageIndex++;
            for (int i = 0; i < buffer.length; i++) {
                if (buffer[i] == ',') {
                    next++;
                    continue;
                }
                if (buffer[i] == '\n'){
                    int bound1 = Integer.parseInt(bound.toString());
                    int salary1 = Integer.parseInt(salaryBase.toString());
                    salary1 = salary1 * 13 + bound1;

                    String nameTemp =name.toString();
                    try {
                        if(i==2712 &&pageIndex==3){

                            int n =1;
                        }
                        if (!temp.get(nameTemp).containsKey(salary1)) {
                            temp.get(nameTemp).put(salary1, 1);
                        } else {
                            temp.get(nameTemp).put(salary1, temp.get(nameTemp).get(salary1) + 1);
                        }
                    }
                    catch (Exception ex){
                        System.out.println("i:"+i+";pageIndex:"+pageIndex);
                        throw ex;

                    }
                    next = 0;
                    name = new StringBuffer();
                    salaryBase = new StringBuffer();
                    bound = new StringBuffer();
                    continue;
                }
                if (next == 0) {
                    if(name.length()<2) {
                        name.append(buffer[i]);
                    }
                    if (name.length() == 2) {
                        if (!temp.containsKey(name.toString())) {
                            temp.put(name.toString(), new HashMap<>(100 * 13 + 5));
                        }
                        continue;
                    }
                }

                if (next == 1) {
                    if (buffer[i] >= '0' && buffer[i] <= '9') {
                        salaryBase.append(buffer[i]);
                    }
                }
                if (next == 2) {
                    if (buffer[i] >= '0' && buffer[i] <= '9') {
                        bound.append(buffer[i]);
                    }
                }

            }
        }


        fr.read(buffer);
        fr.close();
    }


    public void Generate2(String fileName) throws IOException {

        File f = new File(fileName);


        if (f.exists()) {
            f.delete();
            f.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(f);


        Random r = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 1000 * 10000; i++) {
            int n = r.nextInt(100);
            byte name = (byte) (n % 26);
            if (name <= 0) {
                name *= -1;
            }
            char name1, name2, name3, name4;
            name1 = 'a';
            name1 += name;
            name2 = name3 = name4 = name1;
            name2 += 1;
            name3 += 2;
            name4 += 3;

            if (name2 > 'z') {
                name2 -= 26;
            }
            if (name3 > 'z') {
                name3 -= 26;
            }
            if (name4 > 'z') {
                name4 -= 26;
            }


            int baseSalary = n % 100;
            int bonus = n % 5;


            sb.append(name1).append(name2).append(name3).append(name4)
                    .append(split).append(baseSalary)
                    .append(split).append(bonus).append(end);

            if ((i + 1) % 500 == 0) {
                fos.write(sb.toString().getBytes());
                fos.flush();
                sb = new StringBuffer();
            }

        }
        if (sb.length() > 0) {
            fos.write(sb.toString().getBytes());
            fos.flush();
        }

    }
}
