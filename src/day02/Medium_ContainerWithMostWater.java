package day02;
public class Medium_ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) l++; else r--;
        }
        return maxarea;
    }
    public static void main(String[] args) {
        assert maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}) == 49;
        System.out.println("Container With Most Water passed!");
    }
}