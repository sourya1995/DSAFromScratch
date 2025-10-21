package TwoPointers;

/* Leetcode 680 - Valid Palindrome II */
public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s.substring(left + 1, right + 1)) ||
                        isPalindrome(s.substring(left, right));
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
