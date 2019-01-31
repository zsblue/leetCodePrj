package main.java.com.leet.code;

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
public class leet082 {
    public static void main(String args[]) {
        leet082 leet = new leet082();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next.next = new ListNode(5);
        ListNode ret = leet.deleteDuplicates(l1);
        ret.out();

        l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(3);

        ret = leet.deleteDuplicates(l1);
        ret.out();

    }

    public ListNode deleteDuplicates(ListNode head) {

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
