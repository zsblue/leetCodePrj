package main.java.com.leet.code;

import java.util.LinkedHashMap;

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
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class leet234 {

    public static void main(String[] args) {
        leet234 l = new leet234();
        l.test();
    }

    private void test() {

        System.out.println("-----------------");
        ListNode h2 = new ListNode(1);
        h2.next = new ListNode(2);
        System.out.println("1->2");
        System.out.println("false->");
        System.out.println(isPalindrome(h2));


        System.out.println("-----------------");
        h2 = new ListNode(1);
        h2.next = new ListNode(1);
        h2.next.next = new ListNode(2);
        h2.next.next.next = new ListNode(1);
        System.out.println("1->1->2->1");
        System.out.println("true->");
        System.out.println(isPalindrome(h2));


        System.out.println("-----------------");
        h2 = new ListNode(1);
        h2.next = new ListNode(0);
        h2.next.next = new ListNode(1);

        System.out.println("1->0->1");
        System.out.println("true->");
        System.out.println(isPalindrome(h2));

        System.out.println("-----------------");
        h2 = new ListNode(1);
        h2.next = new ListNode(2);
        h2.next.next = new ListNode(2);
        h2.next.next.next = new ListNode(1);
        System.out.println("1->2->2->1");
        System.out.println("true->");
        System.out.println(isPalindrome(h2));

    }

    public boolean isPalindrome2(ListNode head) {

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        ListNode temp = head;
        while (temp != null) {

            s1.append(temp.val);
            s2.insert(0, temp.val);
            temp = temp.next;
        }
        if (s1.toString().equals(s2.toString())) {
            return true;
        }
        return false;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            return head.val == head.next.val;
        }
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast.next != null) {
            if (fast.next.next == null) {
                if (fast.next.val != slow.val) {
                    return false;
                }
                fast.next = null;
                slow = slow.next;
                fast = slow.next;
                if(fast==null||fast.val == slow.val){
                    return true;
                }
            }else{
                fast=fast.next;
            }
        }
        return false;
    }

    public boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        if (head.next.next == null) {
            return head.val == head.next.val;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast.next != null) {
            // 不停的从slow的后一个开始遍历，知道找到值相同的节点
            // 一次完成后，再移动到原节点的下一个节点开始，继续重复上面的步骤
            if (fast.next.val == slow.val) {
                if (fast.next.next != null) {
                    return false;
                }
                fast.next = null;
                slow = slow.next;
                fast = slow.next;
                if (fast == null || fast.val == slow.val) {
                    return true;
                }
            } else {
                fast = fast.next;
            }
        }
        return false;
    }
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
