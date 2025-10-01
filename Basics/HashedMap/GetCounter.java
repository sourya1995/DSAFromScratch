package Basics.HashedMap;

import java.util.HashMap;

public class GetCounter {
    public static HashMap<Integer, Integer> countFrequencies(int[] array){
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num: array){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        return freqMap;

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 4, 4, 4, 5};
        HashMap<Integer, Integer> frequencies = countFrequencies(array);
        System.out.println(frequencies); // Output: {1=1, 2=2, 3=1, 4=3, 5=1}
    }
}
