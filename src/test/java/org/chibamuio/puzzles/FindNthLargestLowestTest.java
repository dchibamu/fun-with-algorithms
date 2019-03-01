package org.chibamuio.puzzles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FindNthLargestLowestTest {

    @Test
    public void shouldReturnThreelargestNumbers(){
        int[] expected = {-3, -1, 0};
        int[] data = {-132, 0, -100, -19, -24, -1, -24, -15, -3, -18};
        assertArrayEquals(expected, FindNthLargestLowest.find3LargestNumbers(data));
    }

    @Test
    public void shouldReturnThreeSmallestNumbers() {
        int[] expected = {-132, -100, -24};
        int[] data = {-132, 0, -100, -19, -24, -1, -24, -15, -3, -18};
        assertArrayEquals(expected, FindNthLargestLowest.find3SmallestValues(data));
    }
}
