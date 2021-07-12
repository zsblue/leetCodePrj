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
 * create by zhangsong 2019/2/11
 * <p>
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class leet0025 {

    public static void main(String args[]) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        leet0025 leet = new leet0025();
        ListNode ret = leet.reverseKGroup(l1, 3);
        ret.out();
        ;


    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        ListNode ret = new ListNode(0);

        ret.next = head;
        ListNode p1 = ret;
        ListNode p2 = head;

        int pc1 = 1;


        while (p2.next != null) {

            while (pc1 < k) {
                pc1++;
                if (p2.next == null) {
                    break;
                }
                p2 = p2.next;

            }
            if (p2.next == null) {
                return head;
            }

            ListNode p3 = p1.next;
            ListNode p4 = p1;
            p4.next = reverse(p1, p2).next;

            p1 = p3;
            p2 = p3.next;
            pc1 = 1;

        }


        return ret.next;
    }


    private ListNode reverse(ListNode p1, ListNode p2) {

        ListNode first = p1;
        p1 = p1.next;
        while (p1.next != null && p1 != p2) {
            ListNode temp = p1.next;

            p1.next = p2.next;
            p2.next = p1;

            if (p1.next == p2) {
                break;
            }
            p1 = temp;
        }
        first.next = p2;
        return first;
    }
}
