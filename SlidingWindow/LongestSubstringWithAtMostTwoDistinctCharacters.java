package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/* Leetcode 159 - Longest Substring with At Most Two Distinct Characters */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> charFrequency = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for(int right = 0; right < s.length(); right++){
            char currentChar = s.charAt(right);

            //add current character to the window
            charFrequency.put(currentChar, charFrequency.getOrDefault(currentChar, 0) + 1); //add to the right

            //shrink the window if we have more than 2 distinct characters
            while(charFrequency.size() > 2){
                char leftChar = s.charAt(left);
                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1); //remove from the left

                //remove the character from map if its frequency becomes 0
                if(charFrequency.get(leftChar) == 0){
                    charFrequency.remove(leftChar);
                }

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
