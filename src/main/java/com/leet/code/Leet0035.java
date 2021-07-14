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
 * @author by zhangsong 2021/7/14
 * <p>
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class Leet0035 {

    public static void main(String[] args) {
        Leet0035 leet = new Leet0035();

        int[] nums = null;
        int target = 0, result;
        int ret;

        nums = new int[]{1, 3, 5, 6};
        target = 5;
        result = 2;

        ret = leet.searchInsert(nums, target);
        System.out.println("r:" + result + ";" + (ret == result) + ";" + ret);


        nums = new int[]{1, 3, 5, 6};
        target = 2;
        result = 1;

        ret = leet.searchInsert(nums, target);
        System.out.println("r:" + result + ";" + (ret == result) + ";" + ret);


        nums = new int[]{1, 3, 5, 6};
        target = 7;
        result = 4;

        ret = leet.searchInsert(nums, target);
        System.out.println("r:" + result + ";" + (ret == result) + ";" + ret);

        nums = new int[]{1, 3, 5, 6};
        target = 0;
        result = 0;

        ret = leet.searchInsert(nums, target);
        System.out.println("r:" + result + ";" + (ret == result) + ";" + ret);

        nums = new int[]{1, 3};
        target =3;
        result = 1;

        ret = leet.searchInsert(nums, target);
        System.out.println("r:" + result + ";" + (ret == result) + ";" + ret);
    }


    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        if (nums[left] >= target) {
            return 0;
        }
        if (nums[right] < target) {
            return right + 1;
        }
        if (nums[right] == target) {
            return right;
        }


        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
