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
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class leet0023 {

    public static void main(String[] args) {

        leet0023 l = new leet0023();


        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);


        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] list = new ListNode[4];
        list[0] =null;
        list[1] = l1;
        list[2] = l2;
        list[3] = l3;


        ListNode ret = l.mergeKLists(list);
        ret.out();


    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ret = null;
        int i = 0;
        for (; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            ret = lists[i];
            break;
        }
        i++;
        for (; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            ret = mergeTwoLists(ret, lists[i]);
        }
        return ret;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ret.next = null;
        ListNode p = ret;
        while (l1 != null || l2 != null) {

            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    p.next = new ListNode(l1.val);

                    l1 = l1.next;
                } else {
                    p.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            } else if (l1 != null && l2 == null) {

                p.next = new ListNode(l1.val);
                l1 = l1.next;

            } else if (l1 == null && l2 != null) {
                p.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            p = p.next;

        }
        return ret.next;
    }
}
