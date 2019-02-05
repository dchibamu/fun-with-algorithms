package org.chibamuio.puzzles;

import org.chibamuio.utils.Pair;

import java.util.HashMap;
import java.util.Map;

public class PuzzleSumSolution {

    /**
     * Finds two values that sum to target from the input array inputNumbers, otherwise returns null if not found
     * @param inputNumbers
     * @param target
     * @return new Pair(int first, int second) if found otherwise it returns null.
     */
    public Pair<Integer> sumTwo(int[] inputNumbers, int target){
        if(inputNumbers == null || inputNumbers.length == 0){
            return null;
        }
        Map<Integer, Integer> sumTwoDiff = new HashMap<>();
        for(int i = 0; i < inputNumbers.length; i++){
            sumTwoDiff.put(inputNumbers[i], target - inputNumbers[i]);
        }
        for(Integer key : sumTwoDiff.keySet()){
            if(sumTwoDiff.containsValue(key)){
                return new Pair<>(key, sumTwoDiff.get(key));
            }
        }
        return new Pair<Integer>(null, null);
    }
}
