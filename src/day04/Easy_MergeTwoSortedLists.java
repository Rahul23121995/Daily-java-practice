package day04;
public class Easy_MergeTwoSortedLists {
    public static class ListNode {
        int val; ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1), current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) { current.next = list1; list1 = list1.next; }
            else { current.next = list2; list2 = list2.next; }
            current = current.next;
        }
        current.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode merged = mergeTwoLists(new ListNode(1, new ListNode(2)), new ListNode(1, new ListNode(3)));
        assert merged != null && merged.val == 1;
        System.out.println("Merge Two Sorted Lists passed!");
    }
}