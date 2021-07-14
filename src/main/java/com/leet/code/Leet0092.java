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
 * create by zhangsong 2019/1/31
 * <p>
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class Leet0092 {

    public static void main(String[] args) {
        Leet0092 l = new Leet0092();

        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(4);
//        l1.next.next.next.next = new ListNode(5);

        ListNode ret = l.reverseBetween(l1, 1, 1);
        ret.out();

    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode ret = new ListNode(0);
        ListNode p2 = ret;

        ListNode pre = new ListNode(0);
        ListNode next = pre;
        ListNode last = pre;

        int i = 1;

        while (p.next != null && i < m) {
            i++;
            p2.next = new ListNode(p.val);
            p2 = p2.next;

            p = p.next;
        }
        while (p.next != null && i < n) {
            i++;
            pre.val = p.val;
            next = new ListNode(0);
            next.next = pre;
            pre = next;
            p = p.next;
        }
        pre.val = p.val;
        p2.next = pre;
        p = p.next;

        while (p != null) {
            last.next = new ListNode(p.val);
            last = last.next;
            p = p.next;
        }

        return ret.next;
    }
}
