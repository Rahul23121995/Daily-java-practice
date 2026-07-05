package day09;
import java.util.HashSet;
import java.util.Set;
public class Easy_ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
    public static void main(String[] args) {
        assert containsDuplicate(new int[]{1, 2, 3, 1}) == true;
        assert containsDuplicate(new int[]{1, 2, 3, 4}) == false;
        System.out.println("Contains Duplicate passed!");
    }
}