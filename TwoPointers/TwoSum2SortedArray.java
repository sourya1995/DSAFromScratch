package TwoPointers;

/* Leetcode 167 - Two Sum II - Input Array Is Sorted
 * We have to use 2 pointers here because the array is sorted, but they must be
 * in the OPPOSITE direction, i.e., one at the start and one at the end.
 * If the sum of the two elements is greater than the target, we move the end
 * pointer to the left (to reduce the sum).
 * If the sum is less than the target, we move the start pointer to the right
 * (to increase the sum).
 * If the sum is equal to the target, we return the indices (1-based).
 * We continue this until the two pointers meet.
 */
public class TwoSum2SortedArray {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int twoSum = numbers[left] + numbers[right];
            if (twoSum == target) {
                return new int[] { left + 1, right + 1 };
            } else if (twoSum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] { -1, -1 };
    }
}
