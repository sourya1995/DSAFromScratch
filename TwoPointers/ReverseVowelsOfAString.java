package TwoPointers;

import java.util.HashSet;
import java.util.Set;

/* Leetcode 345 - Reverse Vowels of a String */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        StringBuilder sb = new StringBuilder(s);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!vowels.contains(sb.charAt(left))) {
                left++;
            } else if (!vowels.contains(sb.charAt(right))) {
                right--;
            } else {
                swap(sb, left, right);
                left++;
                right--;
            }

        }

        return sb.toString();
    }

    private void swap(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }
}
