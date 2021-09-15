import org.junit.Test;
import static org.junit.Assert.*;

public class ReverseLinkedListII {
    /** Definition for singly-linked list. */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode tail = prev.next;
        if (left == 1) {
            tail = head;
        } else {
            for (int i = 2; i < left; i += 1) {
                prev = prev.next;
                tail = prev.next;
            }
        }
        ListNode reversedHead = tail;
        for (int i = 0; i < right - left; i += 1) {
            ListNode temp = tail.next;
            tail.next = temp.next;
            temp.next = reversedHead;
            reversedHead = temp;
        }
        if (left == 1) {
            return reversedHead;
        }
        prev.next = reversedHead;
        return head;
    }

    @Test
    public void testReverseBetween() {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        ListNode reversed = reverseBetween(head, 2, 4);
    }
    @Test
    public void testReverseBetween1() {
        ListNode head = new ListNode(3,
                new ListNode(5));
        ListNode reversed = reverseBetween(head, 1, 2);
    }
}
