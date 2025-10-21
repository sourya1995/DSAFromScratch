package SlidingWindow;

/* Leetcode 1151 - Minimum Swaps to group all 1s together */
public class MinimumSwapsToGroupAllOnesTogether {
    public int minSwaps(int[] data) {
        int totalOnes = 0;
        for (int num : data) {
           totalOnes += num; //count total number of 1s
        }

        if(totalOnes <= 1) {
            return 0; // no swaps needed if there are 0 or 1 ones
        }

        int maxOnesInWindow = 0;
        int currentOnesInWindow = 0;

        // Initial window
        for (int i = 0; i < totalOnes; i++) {
            if (data[i] == 1) {
                currentOnesInWindow++;
            }
        }
        maxOnesInWindow = currentOnesInWindow;

        // Slide the window
        for (int right = totalOnes; right < data.length; right++) {
            int left = right - totalOnes;

            if (data[right] == 1) {
                currentOnesInWindow++;
            }
            if (data[left] == 1) {
                currentOnesInWindow--;
            }

            maxOnesInWindow = Math.max(maxOnesInWindow, currentOnesInWindow);
        }

        return totalOnes - maxOnesInWindow;
    }
}
