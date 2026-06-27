package day08;
public class Hard_MedianTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int x = nums1.length, y = nums2.length, low = 0, high = x;
        while (low <= high) {
            int partitionX = (low + high) / 2, partitionY = (x + y + 1) / 2 - partitionX;
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                else return (double) Math.max(maxLeftX, maxLeftY);
            } else if (maxLeftX > minRightY) high = partitionX - 1;
            else low = partitionX + 1;
        }
        throw new IllegalArgumentException();
    }
    public static void main(String[] args) {
        assert findMedianSortedArrays(new int[]{1, 3}, new int[]{2}) == 2.0;
        System.out.println("Median Two Sorted Arrays passed!");
    }
}