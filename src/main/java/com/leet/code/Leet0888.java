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
 * @author by zhangsong 2021/7/19
 * <p>
 * 888. 公平的糖果棒交换
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 * <p>
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * <p>
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * <p>
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 * 示例 2：
 * <p>
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 * 示例 4：
 * <p>
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 1 <= B.length <= 10000
 * 1 <= A[i] <= 100000
 * 1 <= B[i] <= 100000
 * 保证爱丽丝与鲍勃的糖果总量不同。
 * 答案肯定存在。
 * <p>
 * sumA-x+y = sumB-y+x
 * <p>
 * x = y+(sumA-sumB)/2
 */
public class Leet0888 {


    public static void main(String[] args) {
        Leet0888 leet = new Leet0888();

        int[] A, B, verify, result;

        A = new int[]{1, 1};
        B = new int[]{2, 2};
        verify = new int[]{1, 2};
        result = leet.fairCandySwap(A, B);
        BaseLeet.check(verify, result);

        A = new int[]{1, 2};
        B = new int[]{2, 3};
        verify = new int[]{1, 2};
        result = leet.fairCandySwap(A, B);
        BaseLeet.check(verify, result);

        A = new int[]{2};
        B = new int[]{1, 3};
        verify = new int[]{2, 3};
        result = leet.fairCandySwap(A, B);
        BaseLeet.check(verify, result);

        A = new int[]{1, 2, 5};
        B = new int[]{2, 4};
        verify = new int[]{5, 4};
        result = leet.fairCandySwap(A, B);
        BaseLeet.check(verify, result);
    }


    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int sumA = Arrays.stream(aliceSizes).sum();
        int sumB = Arrays.stream(bobSizes).sum();

        int delta = (sumA - sumB) / 2;

        Set<Integer> set1 = new HashSet<>();

        for (int x : aliceSizes) {

            set1.add(x);
        }

        for (int y : bobSizes) {
            int x = y + delta;
            if (set1.contains(x)) {
                return new int[]{x, y};
            }
        }

        return null;
    }

}
