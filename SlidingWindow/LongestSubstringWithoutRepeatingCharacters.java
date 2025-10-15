package SlidingWindow;

import java.util.HashMap;

/* Leetcode 3 - Longest Substring Without Repeating Characters */
public class LongestSubstringWithoutRepeatingCharacters {
        public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for(int right = 0; right < s.length(); right++){
            char currentChar = s.charAt(right);
            if(map.containsKey(currentChar) && map.get(currentChar) >= left){
                left = map.get(currentChar) + 1;
            }

            map.put(currentChar, right); // add/update the character's index

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
