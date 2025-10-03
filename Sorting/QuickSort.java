package Sorting;

import java.util.List;

public class QuickSort {
    public static void sortListInterval(List<Integer> unsortedList, int start, int end) {
        if (end - start <= 1) {
            return;
        }

        int pivot = unsortedList.get(end - 1);
        int startPointer = start;
        int endPointer = end - 1;

        while (startPointer < endPointer) {
            while (unsortedList.get(startPointer) < pivot && startPointer < endPointer) {
                startPointer++;
            }

            while (unsortedList.get(endPointer) >= pivot && startPointer < endPointer) {
                endPointer--;
            }

            if (startPointer != endPointer) {
                int temp = unsortedList.get(startPointer);
                unsortedList.set(startPointer, unsortedList.get(endPointer));
                unsortedList.set(endPointer, temp);
            }

        }

        int temp = unsortedList.get(startPointer);
        unsortedList.set(startPointer, unsortedList.get(end - 1));
        unsortedList.set(end - 1, temp);

        sortListInterval(unsortedList, start, startPointer);
        sortListInterval(unsortedList, startPointer + 1, end);

    }

    public static List<Integer> quickSort(List<Integer> unsortedList) {
        sortListInterval(unsortedList, 0, unsortedList.size());
        return unsortedList;
    }
}
