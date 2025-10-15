package SlidingWIndow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Leetcode 438 - Find All Anagrams in a String */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        int textLength = s.length();
        int patternLength = p.length();

        List<Integer> result = new ArrayList<>();
        if(textLength < patternLength) return result;

        int patternCount[] = new int[26];
        int windowCount[] = new int[26];

        for(int i = 0; i < patternLength; ++i) {
            patternCount[p.charAt(i) - 'a']++;
            windowCount[s.charAt(i) - 'a']++;
        }

        if(Arrays.equals(windowCount, patternCount)) {
            result.add(0);
        }

        for(int right = patternLength; right < textLength; ++right) {
            int left = right - patternLength;
            windowCount[s.charAt(left) - 'a']--;
            windowCount[s.charAt(right) - 'a']++;

            if(Arrays.equals(windowCount, patternCount)) {
                result.add(left + 1); //starting index of the anagram, the next index after left
            }
        }

        return result;
    }
}
