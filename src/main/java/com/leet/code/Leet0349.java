package com.leet.code;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
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
 * @author by zhangsong 2021/7/15
 * <p>
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 */
public class Leet0349 {

    public static void main(String[] args) {
        Leet0349 leet = new Leet0349();

        int[] nums1, nums2;
        int[] result, verify;

        nums1 = new int[]{1, 2, 2, 1};
        nums2 = new int[]{2, 2};
        verify = new int[]{2};
        result = leet.intersection(nums1, nums2);
        check(result, verify);


        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        verify = new int[]{9, 4};
        result = leet.intersection(nums1, nums2);
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

    public int[] intersection2(int[] nums1, int[] nums2) {


        Arrays.sort(nums1);
        Set<Integer> set = new LinkedHashSet<>();


        for (int i = 0; i < nums2.length; i++) {
            if (i > 0 && nums2[i] == nums2[i - 1]) {
                continue;
            }
            boolean exist = find(nums1, nums2[i]);

            if (exist) {
                set.add(nums2[i]);
            }
        }

        int[] result = new int[set.size()];

        int i = 0;
        for (Integer item : set) {

            result[i++] = item;

        }
        return result;

    }

    private boolean find(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }


    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {

            if (set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }

        int[] result = new int[set2.size()];

        int m = 0;
        for (int item : set2) {
            result[m++] = item;

        }
        return result;
    }
}
