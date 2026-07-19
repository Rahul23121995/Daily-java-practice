package day10;
import java.util.ArrayList;
import java.util.List;
public class Medium_Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(0, new ArrayList<>(), nums, output);
        return output;
    }
    private static void backtrack(int first, ArrayList<Integer> curr, int[] nums, List<List<Integer>> output) {
        output.add(new ArrayList<>(curr));
        for (int i = first; i < nums.length; ++i) {
            curr.add(nums[i]); backtrack(i + 1, curr, nums, output); curr.remove(curr.size() - 1);
        }
    }
    public static void main(String[] args) {
        assert subsets(new int[]{1, 2, 3}).size() == 8;
        System.out.println("Subsets passed!");
    }
}