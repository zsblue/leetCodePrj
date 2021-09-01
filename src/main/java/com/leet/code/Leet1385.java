package com.leet.code;

import java.util.Arrays;

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
 * @author by zhangsong 2021/9/1
 * <p>
 * 1385. 两个数组间的距离值
 * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
 * <p>
 * 「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
 * 输出：2
 * 解释：
 * 对于 arr1[0]=4 我们有：
 * |4-10|=6 > d=2
 * |4-9|=5 > d=2
 * |4-1|=3 > d=2
 * |4-8|=4 > d=2
 * 所以 arr1[0]=4 符合距离要求
 * <p>
 * 对于 arr1[1]=5 我们有：
 * |5-10|=5 > d=2
 * |5-9|=4 > d=2
 * |5-1|=4 > d=2
 * |5-8|=3 > d=2
 * 所以 arr1[1]=5 也符合距离要求
 * <p>
 * 对于 arr1[2]=8 我们有：
 * |8-10|=2 <= d=2
 * |8-9|=1 <= d=2
 * |8-1|=7 > d=2
 * |8-8|=0 <= d=2
 * 存在距离小于等于 2 的情况，不符合距离要求
 * <p>
 * 故而只有 arr1[0]=4 和 arr1[1]=5 两个符合距离要求，距离值为 2
 * 示例 2：
 * <p>
 * 输入：arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr1.length, arr2.length <= 500
 * -10^3 <= arr1[i], arr2[j] <= 10^3
 * 0 <= d <= 100
 */
public class Leet1385 {

    public static void main(String[] args) {
        Leet1385 leet = new Leet1385();

        int[] arr1, arr2;
        int d, result, verify;

        arr1 = new int[]{4, 5, 8};
        arr2 = new int[]{10, 9, 1, 8};
        d = 2;
        verify = 2;
        result = leet.findTheDistanceValue(arr1, arr2, d);
        BaseLeet.check(verify, result);

        arr1 = new int[]{1, 4, 2, 3};
        arr2 = new int[]{-4, -3, 6, 10, 20, 30};
        d = 3;
        verify = 2;
        result = leet.findTheDistanceValue(arr1, arr2, d);
        BaseLeet.check(verify, result);

        arr1 = new int[]{2, 1, 100, 3};
        arr2 = new int[]{-5, -2, 10, -3, 7};
        d = 6;
        verify = 1;
        result = leet.findTheDistanceValue(arr1, arr2, d);
        BaseLeet.check(verify, result);


    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        int result = 0;

        for (int i = 0; i < arr1.length; i++) {

            boolean exist = true;
            for (int j = 0; j < arr2.length; j++) {
                int f = Math.abs(arr1[i] - arr2[j]);

                if (f <= d) {
                    exist = false;
                    break;
                }
            }
            if (exist) {
                result++;
            }
        }
        return result;
    }


    public int findTheDistanceValue2(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int result = 0;
        for (int x : arr1) {

            int left = 0, right = arr2.length;
            boolean f = true;
            int r = 0;
            while (left < right) {
                int mid = (right - left) / 2 + left;

                if (mid >= x) {
                    f = false;
                    r = mid;
                    break;
                }
                left = mid + 1;
                r = left;
            }
            if (f) {

                int n = arr2[r] - x;
                if (r - 1 >= 0) {

                }
                int n2 = x - arr2[r - 1];
                if (n > d) {
                    result++;
                }

            } else {

            }
            int p = binarySearch(arr2, x);
            boolean ok = true;
            if (p < arr2.length) {
                ok &= arr2[p] - x > d;
            }
            if (p - 1 >= 0 && p - 1 <= arr2.length) {
                ok &= x - arr2[p - 1] > d;
            }

        }
        return result;
    }

    public int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        if (arr[high] < target) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
