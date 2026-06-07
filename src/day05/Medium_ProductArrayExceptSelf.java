package day05;
public class Medium_ProductArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        answer[0] = 1;
        for (int i = 1; i < length; i++) answer[i] = nums[i - 1] * answer[i - 1];
        int R = 1;
        for (int i = length - 1; i >= 0; i--) { answer[i] = answer[i] * R; R *= nums[i]; }
        return answer;
    }
    public static void main(String[] args) {
        int[] res = productExceptSelf(new int[]{1, 2, 3, 4});
        assert res[0] == 24;
        System.out.println("Product Except Self passed!");
    }
}