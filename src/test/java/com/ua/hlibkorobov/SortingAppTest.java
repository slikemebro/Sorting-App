package com.ua.hlibkorobov;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Unit tests for SortingApp.
 */
@RunWith(Parameterized.class)
public class SortingAppTest {

    private String[] inputArgs;
    private int[] expectedOutput;
    private boolean expectException;

    public SortingAppTest(String[] inputArgs, int[] expectedOutput, boolean expectException) {
        this.inputArgs = inputArgs;
        this.expectedOutput = expectedOutput;
        this.expectException = expectException;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                // Test case 1: Zero arguments (corner case)
                { new String[]{}, null, true },

                // Test case 2: One argument (corner case)
                { new String[]{"5"}, new int[]{5}, false },

                // Test case 3: Ten arguments (corner case)
                { new String[]{"10", "9", "8", "7", "6", "5", "4", "3", "2", "1"},
                        new int[]{1,2,3,4,5,6,7,8,9,10}, false },

                // Test case 4: More than ten arguments (corner case)
                { new String[]{"1","2","3","4","5","6","7","8","9","10","11"}, null, true },

                // Additional Test case 5: Negative numbers
                { new String[]{"-1", "-3", "-2"}, new int[]{-3, -2, -1}, false },

                // Additional Test case 6: Non-integer argument
                { new String[]{"1", "two", "3"}, null, true },

                // Additional Test case 7: Duplicate numbers
                { new String[]{"4", "2", "4", "2"}, new int[]{2,2,4,4}, false }
        });
    }

    @Test
    public void testParseArgumentsAndSort() {
        if (expectException) {
                assertThrows(IllegalArgumentException.class, () -> SortingApp.parseArgumentsAndSort(inputArgs));
        } else {
            int[] result = SortingApp.parseArgumentsAndSort(inputArgs);
            assertArrayEquals(expectedOutput, result);
        }
    }
}