import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListCycle {
    /** Definition for singly-linked list. */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> marked = new HashSet<>();
        while (head != null) {
            if (marked.contains(head)) {
                return true;
            }
            marked.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycleWithDualPointers(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            if (slow == fast) {
                return true;
            }
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
    @Test
    public void testCycle() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
    }
}
