package com.leet.code;

import java.util.HashMap;

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
 * create by zhangsong 2019/1/31
 * <p>
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * <p>
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class leet0082 extends BaseLeet {
    public static void main(String args[]) {



        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next.next = new ListNode(5);


        Class cls = leet0082.class;
        String methodName = "deleteDuplicates";
        leetRun(cls, methodName, new Object[]{l1});



        l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(3);

        leetRun(cls, methodName, new Object[]{l1});

    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next != null && head.val == head.next.val) {
            // 去除连续重复
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            // 从下一个开始继续去重
            return deleteDuplicates(head.next);
        } else {
            // 去重next的数据
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }

    public ListNode deleteDuplicates3(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        HashMap<Integer, Integer> link = new HashMap<>();

        ListNode p1 = head;
        link.put(p1.val, 1);

        while (p1.next != null) {
            if (!link.containsKey(p1.next.val)) {
                link.put(p1.next.val, 1);
            } else {
                link.put(p1.next.val, link.get(p1.next.val) + 1);
            }
            p1 = p1.next;
        }

        ListNode ret = new ListNode(0);
        ListNode p2 = ret;
        p1 = head;

        while (p1 != null) {
            if (link.get(p1.val) > 1) {
                p1 = p1.next;
                continue;
            }
            p2.next = new ListNode(p1.val);
            p2 = p2.next;

            if (p1.next == null) {
                break;
            }
            p1 = p1.next;
        }


        return ret.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {

        ListNode ret = new ListNode(-1);
        ret.next = head;
        ListNode p1 = ret;
        ListNode p2 = head.next;
        int i = 0;

        while (p2.next != null) {
            i++;
            if (p1.next.val == p2.next.val) {
                p2.next = p2.next.next;
                continue;
            }
            if (i > 1 && p1.next.val == p2.val) {
                p1.next = p2.next;
                p2 = p2.next;
                i = 1;
                if (p2 == null) {
                    break;
                }
            } else {
                p1 = p2;
                p2 = p2.next;
                if (p2.next == null) {
                    break;
                }
            }
        }
        return ret.next;
    }
}
