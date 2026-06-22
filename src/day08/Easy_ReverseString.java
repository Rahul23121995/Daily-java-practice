package day08;
public class Easy_ReverseString {
    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left]; s[left] = s[right]; s[right] = temp;
            left++; right--;
        }
    }
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        assert s[0] == 'o' && s[4] == 'h';
        System.out.println("Reverse String passed!");
    }
}