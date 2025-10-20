package TwoPointers;

/* Leetcode 345 - Reverse Vowels of a String */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            while (left < right && !isVowel(charArray[left])) {
                left++;
            }
            while (left < right && !isVowel(charArray[right])) {
                right--;
            }

            //swap vowels
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }

        return new String(charArray);
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
