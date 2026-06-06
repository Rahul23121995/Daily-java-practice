package day04;
import java.util.*;
public class Medium_GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }
    public static void main(String[] args) {
        assert groupAnagrams(new String[]{"eat", "tea", "tan"}).size() == 2;
        System.out.println("Group Anagrams passed!");
    }
}