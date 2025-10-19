package SlidingWindow;

import java.util.HashMap;

/* Leetcode 76 - Minimum Window Substring */
public class MinimumWindowSubstring {
    /*
     * Variable Role Example value (during run)
     * s The main string we’re scanning "ADOBECODEBANC"
     * t The target pattern "ABC"
     * targetCount What we need (char → count) {A:1, B:1, C:1}
     * windowCount What we currently have {A:1, B:1, C:1, O:1, E:1}
     * requiredChars Number of distinct chars we must have 3
     * satisfiedChars How many are currently satisfied in window 3 (when valid)
     * left Start of current window moves right to shrink
     * right End of current window moves right to expand
     * minWindowStart Start index of smallest valid window found 9
     * minWindowLength Length of that smallest window 4
     */
    public String minWindow(String s, String t) {
        // step 1 - count frequency of each character in 't'
        HashMap<Character, Integer> targetCount = new HashMap<>(); // what we need
        for (char ch : t.toCharArray()) {
            targetCount.put(ch, targetCount.getOrDefault(ch, 0) + 1);
        }

        // step 2 - initialize window and counters
        HashMap<Character, Integer> windowCount = new HashMap<>(); // what we currently have
        int requiredChars = targetCount.size(); // distinct characters needed
        int satisfiedChars = 0; // distinct characters satisfied in window

        // step 3 - track the smallest valid window
        int minWindowStart = -1;
        int minWindowLength = s.length() + 1;

        // left pointer for shrinking the window
        int left = 0;

        // step 4 - expand the window using right pointer
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // add this character to the current window
            windowCount.put(currentChar, windowCount.getOrDefault(currentChar, 0) + 1);

            // if the count of the current char matches the count in t, mark it as satisfied
            if (targetCount.containsKey(currentChar)
                    && windowCount.get(currentChar).intValue() == targetCount.get(currentChar).intValue()) {
                satisfiedChars++;
            }

            // Step 5 - try shrinking the window when it's valid
            while (satisfiedChars == requiredChars) {
                // update the smallest window found
                if ((right - left + 1) < minWindowLength) {
                    minWindowStart = left;
                    minWindowLength = right - left + 1;

                }

                // remove the leftmost character and move left pointer
                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);

                // if we removed a required char and now have less than needed, window becomes
                // invalid
                if (targetCount.containsKey(leftChar) && windowCount.get(leftChar) < targetCount.get(leftChar)) {
                    satisfiedChars--;
                }

                left++;
            }
        }

        // Step 6 - return result
        return minWindowStart == -1 ? "" : s.substring(minWindowStart, minWindowStart + minWindowLength);

    }
}
