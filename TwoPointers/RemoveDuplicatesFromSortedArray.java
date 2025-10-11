package TwoPointers;


/* Leetcode 26 - Remove Duplicates From Sorted Array */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1; // number of unique elements is index + 1
    }
}
