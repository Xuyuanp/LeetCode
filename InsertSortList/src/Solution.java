/**
 * Created by xuyuanp on 5/26/14.
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = null;
        ListNode node = head;

        while (node != null) {
            head = node.next;
            if (newHead == null) {
                newHead = node;
                node.next = null;
            } else if (newHead.val >= node.val) {
                node.next = newHead;
                newHead = node;
            } else {
                ListNode tmp = newHead;
                while (tmp.next != null && tmp.next.val < node.val) {
                    tmp = tmp.next;
                }
                node.next = tmp.next;
                tmp.next = node;
            }

            node = head;
        }

        return newHead;
    }
}
