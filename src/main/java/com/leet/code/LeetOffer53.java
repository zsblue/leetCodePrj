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
 * @author by zhangsong 2021/7/16
 * <p>
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 */
public class LeetOffer53 {

    public static void main(String[] args) {

        LeetOffer53 leet = new LeetOffer53();
        int[] nums;
        int target,result, verify;

        nums = new int[]{5, 7, 7, 8, 8, 10};
        target = 8;
        verify = 2;
        result = leet.search(nums,target);
        System.out.println("===>" + verify + ";" + (result == verify) + ";" + result);


        nums = new int[]{5, 7, 7, 8, 8, 10};
        target = 6;
        verify = 0;
        result = leet.search(nums,target);
        System.out.println("===>" + verify + ";" + (result == verify) + ";" + result);


    }

    public int search(int[] nums, int target) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > target) {
                break;
            }
            if (nums[i] == target) {
                count++;
            }
        }

        return count;
    }

}
