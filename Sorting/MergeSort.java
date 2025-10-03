package Sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static List<Integer> sortListInterval(List<Integer> unsortedList, int start, int end) {

        // Base case: if the list has one or zero elements, it's already sorted
        if (end - start <= 1) {
            return unsortedList.subList(start, end);
        }

        // Recursive case: split the list into halves and merge sort each half
        int midpoint = (start + end) / 2;
        List<Integer> left = sortListInterval(unsortedList, start, midpoint);
        List<Integer> right = sortListInterval(unsortedList, midpoint, end);

        // Merge the sorted halves
        ArrayList<Integer> resultList = new ArrayList<>();
        int leftPointer = 0, rightPointer = 0;

        // Merge the two lists while there are elements in both
        while (leftPointer < left.size() && rightPointer < right.size()) {
            // If one list is exhausted, add elements from the other list    
            if (leftPointer == left.size()) {
                resultList.add(right.get(rightPointer));
                rightPointer++;
            } else if (rightPointer == right.size()) {
                resultList.add(left.get(leftPointer));
                leftPointer++;
            // If the current element in the left list is smaller or equal, add it to the result
            } else if (left.get(leftPointer) <= right.get(rightPointer)) {
                resultList.add(left.get(leftPointer));
                leftPointer++;
            } else {
                resultList.add(right.get(rightPointer));
                rightPointer++;
            }
        }

        return resultList;

    }
    // Helper method to sort the entire list
    public static List<Integer> sortList(List<Integer> unsortedList) {
        return sortListInterval(unsortedList, 0, unsortedList.size());
    }

    
}
