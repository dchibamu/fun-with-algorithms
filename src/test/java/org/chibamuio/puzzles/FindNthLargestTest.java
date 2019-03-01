package org.chibamuio.puzzles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FindNthLargestTest {

    @Test
    public void shouldReturnThreelargestNumbers(){
        int[] expected = {-3, -1, 0};
        int[] data = {-132, 0, -100, -19, -24, -1, -24, -15, -3, -18};
        assertArrayEquals(expected, FindNthLargest.find3LargestNumbers(data));
    }
}
