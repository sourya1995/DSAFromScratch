package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Leetcode 283 - Move Zeroes */
public class MoveZeroes {
  // -------------------------------
    // 1️⃣ Inefficient (extra array)
    // -------------------------------
    public static void moveZerosInefficient(List<Integer> nums) {
        // Copy non-zero elements into a new list
        ArrayList<Integer> nonzeros = new ArrayList<>();
        for (int n : nums) {
            if (n != 0) {
                nonzeros.add(n);
            }
        }

        // Copy back into original list
        int i = 0;
        for (; i < nonzeros.size(); i++) {
            nums.set(i, nonzeros.get(i));
        }

        // Fill the rest with zeros
        for (; i < nums.size(); i++) {
            nums.set(i, 0);
        }
    }

    // -------------------------------
    // 2️⃣ Semi-optimal (in-place, two passes)
    // -------------------------------
    public static void moveZerosInPlace(List<Integer> nums) {
        int i = 0;
        // First pass — move all non-zero elements forward
        for (int n : nums) {
            if (n != 0) {
                nums.set(i, n);
                i++;
            }
        }

        // Second pass — fill remaining positions with zeros
        for (; i < nums.size(); i++) {
            nums.set(i, 0);
        }
    }

    // -------------------------------
    // 3️⃣ Optimal (two-pointer swap, for arrays)
    // -------------------------------
    public static void moveZeroesArray(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                // Swap non-zero element to the slow position
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
        }
    }

    // -------------------------------
    // 🧪 Test the three methods
    // -------------------------------
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>(Arrays.asList(0, 1, 0, 3, 12));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(0, 1, 0, 3, 12));
        int[] array = {0, 1, 0, 3, 12};

        moveZerosInefficient(list1);
        System.out.println("Inefficient: " + list1); // [1, 3, 12, 0, 0]

        moveZerosInPlace(list2);
        System.out.println("In-place (List): " + list2); // [1, 3, 12, 0, 0]

        moveZeroesArray(array);
        System.out.println("Optimal (Array): " + Arrays.toString(array)); // [1, 3, 12, 0, 0]
    }
}
