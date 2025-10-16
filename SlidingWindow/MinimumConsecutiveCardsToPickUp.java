package SlidingWindow;

import java.util.HashMap;

/* Leetcode 2260 - Minimum Consecutive Cards to Pick Up */
public class MinimumConsecutiveCardsToPickUp {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int minLength = cards.length + 1;
        for (int right = 0; right < cards.length; ++right) {
            int currentCard = cards[right];

            if (map.containsKey(currentCard)) {
                int left = map.get(currentCard);
                minLength = Math.min(minLength, right - left + 1);
            }

            map.put(currentCard, right);
        }

        if (minLength > cards.length) {
            return -1;
        }

        return minLength;

    }
}
