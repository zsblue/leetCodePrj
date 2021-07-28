package com.leet.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
 * @author by zhangsong 2021/7/27
 * <p>
 * 1346. 检查整数及其两倍数是否存在
 * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
 * <p>
 * 更正式地，检查是否存在两个下标 i 和 j 满足：
 * <p>
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [10,2,5,3]
 * 输出：true
 * 解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
 * 示例 2：
 * <p>
 * 输入：arr = [7,1,14,11]
 * 输出：true
 * 解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
 * 示例 3：
 * <p>
 * 输入：arr = [3,1,7,11]
 * 输出：false
 * 解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= arr.length <= 500
 * -10^3 <= arr[i] <= 10^3
 */
public class Leet1346 {

    public static void main(String[] args) {
        Leet1346 leet = new Leet1346();

        int[] arr;
        boolean result, verify;

        arr = new int[]{10, 2, 5, 3};
        verify = true;
        result = leet.checkIfExist(arr);
        BaseLeet.check(verify, result);

        arr = new int[]{7, 1, 14, 11};
        verify = true;
        result = leet.checkIfExist(arr);

        BaseLeet.check(verify, result);

        arr = new int[]{3, 1, 7, 11};
        verify = false;
        result = leet.checkIfExist(arr);
        BaseLeet.check(verify, result);


        arr = new int[]{-10, 12, -20, -8, 15};
        verify = true;
        result = leet.checkIfExist(arr);
        BaseLeet.check(verify, result);


        arr = new int[]{-2, 0, 10, -19, 4, 6, -8};
        verify = false;
        result = leet.checkIfExist(arr);
        BaseLeet.check(verify, result);

        arr = new int[]{0, 0};
        verify = true;
        result = leet.checkIfExist(arr);
        BaseLeet.check(verify, result);


    }

    public boolean checkIfExist1(int[] arr) {


        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] % 2 == 1 || arr[i] % 2 == -1) {
                continue;
            }
            int f = arr[i] / 2;

            for (int j = 0; j < arr.length; j++) {

                if (i == j) {
                    continue;
                }
                if (arr[j] == f) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * hash方式
     *
     * @param arr
     * @return
     */
    public boolean checkIfExist2(int[] arr) {


        Set<Integer> set = new HashSet<>();

        int zeroCount = 0;
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
            if (arr[i] == 0) {
                zeroCount++;
            }
        }

        if (zeroCount > 1) {
            return true;
        }

        for (Integer item : set) {

            if (item == 0) {
                continue;
            }
            if (item % 2 == 1 || item % 2 == -1) {
                continue;
            }
            int f = item / 2;

            if (set.contains(f)) {
                return true;
            }
        }

        return false;
    }

    public boolean checkIfExist3(int[] arr) {

        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {

            if (set.contains(arr[i] * 2)) {
                return true;
            }
            if (arr[i] % 2 == 0 && set.contains(arr[i] / 2)) {
                return true;
            }

            set.add(arr[i]);

        }


        return false;
    }

    /**
     * 双指针
     *
     * @param arr
     * @return
     */
    public boolean checkIfExist(int[] arr) {


        Arrays.sort(arr);
        int q = 0;
        for(int p = 0; p < arr.length; p++) {
            while(q < arr.length && arr[p] * 2 > arr[q]) {
                q++;
            }
            if(q != arr.length && p != q && arr[p] * 2 == arr[q]) {
                return true;
            }
        }

        return false;
    }

    public boolean checkIfExist4(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            int item = arr[i];

            if (item % 2 == 1 || item % 2 == -1) {
                continue;
            }
            int left = 0, right = arr.length - 1;

            while (left < right) {

                if (left == i) {
                    left++;
                }
                if (right == i) {
                    right--;
                }

                if (arr[left] < 0) {

                }
            }

        }
        return false;
    }


}
