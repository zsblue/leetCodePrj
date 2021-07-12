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
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class leet0086 extends BaseLeet {

    public static void main(String args[]) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(2);

        leet0086 leet = new leet0086();
        leet.partition(l1, 3).out();

    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode l1 = new ListNode(0);
        ListNode ret = l1;
        l1.next = head;
        while (l1.next != null) {
            if (l1.next.val < x) {
                l1 = l1.next;
            } else {
                break;
            }
            if (l1.next == null) {
                break;
            }
        }
        ListNode l2 = l1;
        while (l2.next != null) {
            if (l2.next.val < x) {
                ListNode temp = l1.next;
                l1.next = l2.next;
                l2.next = l2.next.next;
                l1 = l1.next;
                l1.next = temp;
                continue;
            }
            l2 = l2.next;
        }
        return ret.next;
    }


}
