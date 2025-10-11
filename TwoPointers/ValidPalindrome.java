package TwoPointers;

/* Leetcode 125 - Valid Palindrome */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            //skip non-alphanumeric characters
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }


        left++;
        right--;
        }
        return true;
    }

    public boolean isPalindromeMoreSpace(String s) {
        int left = 0;

        String cleanedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int right = cleanedString.length() - 1;
        while (left < right) {
            if (cleanedString.charAt(left) != cleanedString.charAt(right)) {
                return false;
            }
            left = left + 1;
            right = right - 1;
        }
        return true;
    }
}
