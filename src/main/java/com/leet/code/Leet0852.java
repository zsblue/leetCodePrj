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
 *
 * @author by zhangsong 2021/7/19
 * <p>
 * 852. 山脉数组的峰顶索引
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [0,1,0]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：arr = [0,2,1,0]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：arr = [0,10,5,2]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：arr = [3,4,5,1]
 * 输出：2
 * 示例 5：
 * <p>
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^6
 * 题目数据保证 arr 是一个山脉数组
 * <p>
 * <p>
 * 进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？
 */
public class Leet0852 {


    public static void main(String[] args) {
        Leet0852 leet = new Leet0852();

        int[] arr;
        int result, verify;

        arr = new int[]{0, 1, 0};
        verify = 1;
        result = leet.peakIndexInMountainArray(arr);
        System.out.println("===>" + verify + ";" + result + ";" + (result == verify));

        arr = new int[]{0, 2, 1, 0};
        verify = 1;
        result = leet.peakIndexInMountainArray(arr);
        System.out.println("===>" + verify + ";" + result + ";" + (result == verify));

        arr = new int[]{0, 10, 5, 2};
        verify = 1;
        result = leet.peakIndexInMountainArray(arr);
        System.out.println("===>" + verify + ";" + result + ";" + (result == verify));

        arr = new int[]{3, 4, 5, 1};
        verify = 2;
        result = leet.peakIndexInMountainArray(arr);
        System.out.println("===>" + verify + ";" + result + ";" + (result == verify));

        arr = new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        verify = 2;
        result = leet.peakIndexInMountainArray(arr);
        System.out.println("===>" + verify + ";" + result + ";" + (result == verify));
    }

    public int peakIndexInMountainArray2(int[] arr) {

        int left = 1, right = arr.length - 2;

        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            if (arr[mid] >= arr[mid - 1] && arr[mid] <= arr[mid + 1]) {
                left = mid + 1;

            } else if (arr[mid] < arr[mid - 1] && arr[mid] >= arr[mid + 1]) {
                right = mid - 1;
            }
        }
        return left - 1;

    }

    public int peakIndexInMountainArray(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }


}
