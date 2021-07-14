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
 * create by zhangsong 2019/1/28
 * <p>
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * <p>
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class Leet0004 {
    public static void main(String[] args) {

        Leet0004 l = new Leet0004();

        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};

        System.out.println(l.findMedianSortedArrays(nums1, nums2));

        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        System.out.println(l.findMedianSortedArrays(nums1, nums2));


    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int n1 = 0;
        int n2 = 0;

        if (nums1.length == 0) {
            return getCenter(nums2);
        }
        if (nums2.length == 0) {
            return getCenter(nums1);
        }

        int m = (nums1.length + nums2.length + 1) / 2;

        int currentIndex = 0;
        int[] ret = new int[m + 1];
        while (currentIndex <= m) {

            if (n1 < nums1.length && n2 < nums2.length) {

                if (nums1[n1] < nums2[n2]) {
                    ret[currentIndex++] = nums1[n1];
                    n1++;
                    continue;
                } else {
                    ret[currentIndex++] = nums2[n2];
                    n2++;
                    continue;
                }
            }
            if (n1 < nums1.length && n2 >= nums2.length) {

                ret[currentIndex++] = nums1[n1];
                n1++;
                continue;
            }
            if (n1 >= nums1.length && n2 < nums2.length) {
                ret[currentIndex++] = nums2[n2];
                n2++;
                continue;
            }

        }
        if ((nums1.length + nums2.length) % 2 == 0) {

            return (ret[m - 1] + ret[m]) / 2.0;
        }
        return ret[m - 1];
    }

    private double getCenter(int[] nums) {
        int m = nums.length / 2;
        if (nums.length % 2 == 0) {
            return (nums[m - 1] + nums[m]) / 2.0;
        } else {
            return nums[m];
        }
    }


    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

}
