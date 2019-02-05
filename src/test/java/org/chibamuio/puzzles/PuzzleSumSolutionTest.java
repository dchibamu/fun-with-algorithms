package org.chibamuio.puzzles;

import org.chibamuio.utils.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PuzzleSumSolutionTest {

    @Test
    @DisplayName("Should find number 7 and 8 with target sum of 15")
    void shouldFindTwoNumbersAddingUpToTarget(){
        int[] inputNumbers = {4, 6, 7, 1, 3, 8, 7};
        int target = 15;
        int expectedFirst = 7;
        int expectedSecond = 8;
        PuzzleSumSolution sumSolution = new PuzzleSumSolution();
        Pair<Integer> output = sumSolution.sumTwo(inputNumbers, target);
        assertEquals(output.getFirst().intValue(), expectedFirst);
        assertEquals(output.getSecond().intValue(), expectedSecond);
    }

    @Test
    @DisplayName("Should return null")
    void shouldReturnNullIfPassedEmptyInputArray(){
        int[] inputNumbers = null;
        int target = 15;
        PuzzleSumSolution sumSolution = new PuzzleSumSolution();
        Pair<Integer> output = sumSolution.sumTwo(inputNumbers, target);
        assertNull(output);
    }
}
