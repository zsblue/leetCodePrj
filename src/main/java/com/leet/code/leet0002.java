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
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 解释：342 + 465 = 807
 *
 */
public class leet0002 {

    public static void main(String[] args) {

        leet0002 l = new leet0002();
        l.test();


    }

    public void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(2);


        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(1);

        ListNode ret = addTwoNumbers(l1, null);

        System.out.println("======================");
        sOut(ret);
        System.out.println();
        System.out.println("======================");


    }

    private void sOut(ListNode l) {
        System.out.print(l.val);
        if (l.next != null) {
            System.out.print("->");
            sOut(l.next);
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode ret = new ListNode(0);

        add(ret, l1);
        add(ret, l2);
        return ret;
    }

    private void add(ListNode ret, ListNode l) {

        int v = ret.val;
        if (l != null && l.val > 0) {
            v += l.val;
        }
        ret.val = v % 10;

        if (v >= 10) {
            if (ret.next == null) {
                ret.next = new ListNode(v / 10);
            } else {
                ret.next.val += v / 10;
            }
        }
        if (ret.next == null) {
            if (l == null || l.next == null) {
                return;
            }
            ret.next = new ListNode(0);
        }
        if (l==null || l.next == null) {
            add(ret.next, null);
        } else {
            add(ret.next, l.next);
        }
    }



}
