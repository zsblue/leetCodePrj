package main.java.com.leet.code;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
 * create by zhangsong 2019/1/30
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */
public class leet019 {

    public static void main(String[] args) {

        leet019 l = new leet019();

        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);
//        ln.next.next = new ListNode(3);
//        ln.next.next.next = new ListNode(4);
//        ln.next.next.next.next = new ListNode(5);

        ListNode ret = l.removeNthFromEnd(ln, 1);

        ret.out();
    }


    public ListNode removeNthFromEnd2(ListNode head, int n) {

        //删除第 m-n+1个节点

        if (n <= 0) {
            return head;
        }

        ListNode first = head;
        ListNode sencod = head;
        int m = 0;
        while (first != null) {
            m++;
            first = first.next;
        }
        int k = m - n + 1;
        if (k == 1) {
            return head.next;
        }

        int current = 1;
        while (current < k - 1) {

            sencod = sencod.next;
            current++;
        }
        if (sencod.next.next != null) {
            sencod.next = sencod.next.next;
        } else {
            sencod.next = null;
        }

        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        //双指针，间隔n个

        if (n <= 0) {
            return head;
        }

        ListNode first = head;
        ListNode sencod = head;
        int m = 0;
        int count = 0;
        while (sencod.next != null) {
            count++;
            if (m < n) {
                m++;
                sencod = sencod.next;
                continue;
            }
            first = first.next;
            sencod = sencod.next;
        }

        if (n == count + 1) {
            return head.next;
        } else if (count + 1 > n) {
            first.next = first.next.next;
        }

        return head;
    }

}
