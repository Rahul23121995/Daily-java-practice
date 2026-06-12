package day06;
import java.util.ArrayDeque;
import java.util.Deque;
public class Hard_SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;
        Deque<Integer> deq = new ArrayDeque<>();
        int[] output = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            if (!deq.isEmpty() && deq.peekFirst() < i - k + 1) deq.pollFirst();
            while (!deq.isEmpty() && nums[deq.peekLast()] < nums[i]) deq.pollLast();
            deq.offerLast(i);
            if (i >= k - 1) output[i - k + 1] = nums[deq.peekFirst()];
        }
        return output;
    }
    public static void main(String[] args) {
        int[] res = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        assert res[0] == 3;
        System.out.println("Sliding Window Maximum passed!");
    }
}