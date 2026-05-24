package day01;
import java.util.PriorityQueue;
public class Hard_MergeKSortedLists {
    public static class ListNode {
        int val; ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode node : lists) if (node != null) queue.add(node);
        ListNode dummy = new ListNode(-1), current = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            current.next = node; current = current.next;
            if (node.next != null) queue.add(node.next);
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode[] lists = { new ListNode(1, new ListNode(4)), new ListNode(1, new ListNode(3)), new ListNode(2) };
        ListNode merged = mergeKLists(lists);
        assert merged != null && merged.val == 1;
        System.out.println("Merge K Sorted Lists passed!");
    }
}