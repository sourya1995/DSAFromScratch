package TwoPointers;

import java.util.Arrays;

/* Leetcode 881 - Boats to Save People */
public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int leftIndex = 0;
        int rightIndex = people.length - 1;
        int boatCount = 0;

        while (leftIndex <= rightIndex) {

            // try to pair the lightest person with the heaviest person
            if (people[leftIndex] + people[rightIndex] <= limit) {
                leftIndex++; // lightest person gets on
            }
            rightIndex--; // heaviest person always gets on
            boatCount++;
        }

        return boatCount;

    }
}
