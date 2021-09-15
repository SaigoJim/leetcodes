import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class IntersectionOfTwoLinkedLists {
    /** Definition for singly-linked list. */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> setA = new HashSet<>();
        while (headA != null) {
            setA.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (setA.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
    @Test
    public void testIntersect() {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(1);
        headB.next.next = new ListNode(3);
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(9);
        headA.next.next = intersect;
        headB.next.next.next = intersect;

        ListNode result = getIntersectionNode(headA, headB);
    }
}
