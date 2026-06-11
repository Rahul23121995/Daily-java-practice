package day06;
public class Easy_ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) if (count != 0) return false;
        return true;
    }
    public static void main(String[] args) {
        assert isAnagram("anagram", "nagaram") == true;
        assert isAnagram("rat", "car") == false;
        System.out.println("Valid Anagram passed!");
    }
}