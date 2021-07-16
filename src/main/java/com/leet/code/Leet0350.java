package com.leet.code;

import javax.swing.text.html.parser.Entity;
import java.util.*;

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
 * @author by zhangsong 2021/7/16
 * <p>
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Leet0350 {
    public static void main(String[] args) {
        Leet0350 leet = new Leet0350();

        int[] nums1, nums2;
        int[] result, verify;

        nums1 = new int[]{1, 2, 2, 1};
        nums2 = new int[]{2, 2};
        verify = new int[]{2};
        result = leet.intersect(nums1, nums2);
        check(result, verify);


        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        verify = new int[]{9, 4};
        result = leet.intersect(nums1, nums2);
        check(result, verify);

    }

    private static void check(int[] result, int[] verify) {

        boolean flg = true;

        if (result.length != verify.length) {
            flg = false;
        } else {
            for (int i = 0; i < result.length; i++) {
                if (result[i] != verify[i]) {
                    flg = false;
                    break;
                }
            }
        }

        System.out.println(flg + "====>");
        System.out.println(Arrays.toString(verify));
        System.out.println(Arrays.toString(result));

        System.out.println();


    }

    public int[] intersect2(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> hash1 = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            int count = hash1.getOrDefault(nums1[i], 0) + 1;
            hash1.put(nums1[i], count);
        }
        int index = 0;
        int[] result = new int[nums1.length];
        for (int num : nums2) {
            int count = hash1.getOrDefault(num, 0);
            if (count > 0) {
                result[index++] = num;
                count--;
                if (count > 0) {
                    hash1.put(num, count);
                } else {
                    hash1.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }


    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        int[] result = new int[Math.min(len1, len2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < len1 && index2 < len2) {
            if (nums1[index1] > nums2[index2]) {
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                result[index++] = nums1[index1];
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }

}
