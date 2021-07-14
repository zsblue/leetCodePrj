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
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * <p>
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * 示例 2：
 * <p>
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 示例 3：
 * <p>
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= numbers.length <= 3 * 10^4
 * -1000 <= numbers[i] <= 1000
 * numbers 按 递增顺序 排列
 * -1000 <= target <= 1000
 * 仅存在一个有效答案
 */
public class Leet0167 {


    public static void main(String[] args) {
        Leet0167 leet = new Leet0167();

        int[] numbers, ret, result;
        int target;
        numbers = new int[]{2, 7, 11, 15};
        target = 9;
        result = new int[]{1, 2};

        ret = leet.twoSum(numbers, target);

        System.out.println("[" + result[0] + "," + result[1] + "]==" + (result[0] == ret[0] && result[1] == ret[1]) + "==>[" + ret[0] + "," + ret[1] + "]");


        numbers = new int[]{2, 3, 4};
        target = 6;
        result = new int[]{1, 3};
        ret = leet.twoSum(numbers, target);
        System.out.println("[" + result[0] + "," + result[1] + "]==" + (result[0] == ret[0] && result[1] == ret[1]) + "==>[" + ret[0] + "," + ret[1] + "]");


    }

    public int[] twoSum(int[] numbers, int target) {

        int len = numbers.length;
        int[] ret = new int[2];
        for (int i = 0; i < len; i++) {
            int left = i + 1;
            int right = len - 1;

            while (left < right) {
                int mid = (right - left) / 2 + left;

                int r = numbers[i] + numbers[mid];
                if (r == target) {
                    return new int[]{i + 1, mid + 1};
                }
                if (r < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == len - 1) {
                int r = numbers[i] + numbers[left];
                if (r == target) {
                    return new int[]{i + 1, left + 1};
                }
            }
        }
        return new int[]{-1, -1};
    }


}
