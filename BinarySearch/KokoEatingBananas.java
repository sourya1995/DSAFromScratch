package BinarySearch;

/* Leetcode 875 - Koko Eating Bananas */

public class KokoEatingBananas {
    private static boolean canEatAll(int[] piles, int h, int k) {
        int hoursNeeded = 0; // total hours needed to eat all bananas

        for (int pile : piles) {
            hoursNeeded += (pile + k - 1) / k; // equivalent to Math.ceil(pile / k), alternatively use (int)Math.ceil((double)pile / k)
            // this calculates how many hours Koko needs to eat the current pile at speed k
            if (hoursNeeded > h) {
                return false; // if we exceed the allowed hours, return false
            }
        }
        return true; // all piles can be eaten within the allowed hours
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // potential answer

            if (canEatAll(piles, h, mid)) {
                result = mid; // update result
                right = mid - 1; // try for a smaller eating speed
            } else {
                left = mid + 1; // increase eating speed
                }
        }

        return result;
    }
}
