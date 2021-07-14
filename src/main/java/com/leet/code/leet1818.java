package com.leet.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.LongToDoubleFunction;

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
 * 1818. 绝对差值和
 * 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 * <p>
 * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
 * <p>
 * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 * <p>
 * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
 * <p>
 * |x| 定义为：
 * <p>
 * 如果 x >= 0 ，值为 x ，或者
 * 如果 x <= 0 ，值为 -x
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,7,5], nums2 = [2,3,5]
 * 输出：3
 * 解释：有两种可能的最优方案：
 * - 将第二个元素替换为第一个元素：[1,7,5] => [1,1,5] ，或者
 * - 将第二个元素替换为第三个元素：[1,7,5] => [1,5,5]
 * 两种方案的绝对差值和都是 |1-2| + (|1-3| 或者 |5-3|) + |5-5| = 3
 * 示例 2：
 * <p>
 * 输入：nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
 * 输出：0
 * 解释：nums1 和 nums2 相等，所以不用替换元素。绝对差值和为 0
 * 示例 3：
 * <p>
 * 输入：nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
 * 输出：20
 * 解释：将第一个元素替换为第二个元素：[1,10,4,4,2,7] => [10,10,4,4,2,7]
 * 绝对差值和为 |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums1.length
 * n == nums2.length
 * 1 <= n <= 105
 * 1 <= nums1[i], nums2[i] <= 105
 * <p>
 * <p>
 * 思路：
 * sum(|nums1[i]-nums2[i]|)-max(|nums1[i]-nums2[i]|-|nums1[j]-nums2[i]|)
 * 1个记录nums1的数据，排序 record
 * 计算差总和 sum
 * 查找每组的最大差值 maxn，在record中查找与nums2[i]最接近的数据
 * 返回(sum-maxn)%mod
 */
public class leet1818 {

    public static void main(String[] args) {
        leet1818 leet = new leet1818();

        int ret, result;
        int[] nums1, nums2;

        nums1 = new int[]{1, 7, 5};
        nums2 = new int[]{2, 3, 5};
//         ret = leet.minAbsoluteSumDiff(nums1,
//                nums2);
//        int result = 3;
//        System.out.println("===>" + result + ";" + (result == ret) + ";" + ret);
//
//
//        nums1 = new int[]{2, 4, 6, 8, 10};
//        nums2 = new int[]{2, 4, 6, 8, 10};
//        ret = leet.minAbsoluteSumDiff(nums1,
//                nums2);
//        result = 0;
//        System.out.println("===>" + result + ";" + (result == ret) + ";" + ret);
//
//
//        nums1 = new int[]{1, 10, 4, 4, 2, 7};
//        nums2 = new int[]{9, 3, 5, 1, 7,  4};
//
//        ret = leet.minAbsoluteSumDiff(nums1, nums2);
//        result = 20;
//        System.out.println("===>" + result + ";" + (result == ret) + ";" + ret);
//
//
//        nums1 = new int[]{1, 10, 4, 4, 2, 7};
//        nums2 = new int[]{9, 3, 5, 1, 7, 4};
//        ret = leet.minAbsoluteSumDiff(nums1,   nums2);
//        result = 20;
//        System.out.println("===>" + result + ";" + (result == ret) + ";" + ret);
//
//
//        nums1 = new int[]{1, 28, 21};
//
//        nums2 = new int[]{9, 21, 20};
//        result = 9;
//
//        ret = leet.minAbsoluteSumDiff(nums1,
//                nums2);
//
//        System.out.println("===>" + result + ";" + (result == ret) + ";" + ret);


        int[] tnums1, tnums2;

        tnums1 = readFromFile("nums1");
        tnums2 = readFromFile("nums2");


        result = 999979264;

        ret = leet.minAbsoluteSumDiff(tnums1, tnums2);
        System.out.println("===>" + result + ";" + (result == ret) + ";" + ret);


    }

    private static int[] readFromFile(String filename) {
        Path filePath = Paths.get(filename);
        Charset charset = StandardCharsets.UTF_8;

        int[] list = new int[89929];
        int i = 0;
        try (BufferedReader bufferedReader = Files.newBufferedReader(filePath, charset)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                list[i] = Integer.parseInt(line);
                i++;
            }
        } catch (IOException ex) {
            System.out.format("I/O error: %s%n", ex);
        }
        return list;
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {

        int mod = 1000000007;
        long ret = 0;

        int len = nums1.length;
        int maxn = 0;

        int[] record = new int[len];
        System.arraycopy(nums1, 0, record, 0, len);
        Arrays.sort(record);
        for (int i = 0; i < len; i++) {

            int m = Math.abs(nums1[i] - nums2[i]);
            if (m == 0) {
                continue;
            }
            ret = (ret + m);

            int j = find(record, nums2[i]);

            if (j < len) {
                maxn = Math.max(maxn, (m - Math.abs(record[j] - nums2[i])));
            }
            if (j > 0) {
                maxn = Math.max(maxn, (m - Math.abs(record[j - 1] - nums2[i])));
            }
        }

        System.out.println("sum:" + ret + ";maxn:" + maxn);
        return (int) ((ret - maxn) % mod);
    }

    private int find(int[] record, int target) {

        int left = 0,
                right = record.length - 1;

        if (record[right] < target) {
            return record.length;
        }
        if (record[right] == target) {
            return right;
        }
        if (record[left] >= target) {
            return 0;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (record[mid] == target) {
                return mid;
            } else if (record[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
