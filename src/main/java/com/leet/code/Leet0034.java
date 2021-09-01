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
 * @author by zhangsong 2021/7/30
 * <p>
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums 是一个非递减数组
 * -10^9 <= target <= 10^9
 */
public class Leet0034 {
    public static void main(String[] args) {
        Leet0034 leet = new Leet0034();

        int[] nums;
        int target;
        int[] result, verify;

        nums = new int[]{5,7,7,8,8,10};

        target = 8;
        verify = new int[]{3,4};
        result = leet.searchRange(nums,target);
        BaseLeet.check(verify,result);


        target = 6;
        verify = new int[]{-1,-1};
        result = leet.searchRange(nums,target);
        BaseLeet.check(verify,result);

        target = 0;
        verify = new int[]{-1,-1};
        result = leet.searchRange(nums,target);
        BaseLeet.check(verify,result);



    }

    private int[] searchRange(int[] nums, int target) {

        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {

            if (target > nums[i]) {
                continue;
            }
            if (target < nums[i]) {
                break;
            }
            if (target == nums[i]) {
                if (start < 0) {
                    start = i;
                    end =i;
                } else {
                    end = i;
                }
            }
        }

        return new int[]{start, end};
    }
}
