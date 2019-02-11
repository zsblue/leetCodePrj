package com.leet.code;

import java.util.ArrayList;
import java.util.List;

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
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class leet206 {
    public static void main(String[] args) {

        leet206 l = new leet206();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode ret = l.reverseList(l1);
        ret.out();

    }

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode p = head;
        ListNode ret = new ListNode(0);
        ListNode next = ret;

        while (p.next != null) {

            ret.val = p.val;
            next = new ListNode(0);
            next.next = ret;
            ret = next;

            p = p.next;
        }
        ret.val = p.val;
        return ret;
    }

    public ListNode reverseList2(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode p = head;
        List<Integer> nlist = new ArrayList<>();
        while (p.next != null) {
            nlist.add(p.val);
            p = p.next;
        }
        nlist.add(p.val);

        ListNode ret = new ListNode(0);
        ret.next = null;
        p = ret;

        int i = nlist.size() - 1;
        for (; i >= 0; i--) {
            ret.next = new ListNode(nlist.get(i));
            ret = ret.next;
        }
        return p.next;
    }


}
