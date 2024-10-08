package com.ua.hlibkorobov;

import java.util.Arrays;

import static com.ua.hlibkorobov.SortingApp.parseArgumentsAndSort;

public class App {

    /**
     * The entry point of the application.
     *
     * @param args the input integer arguments to be sorted
     */
    public static void main(String[] args) {
        try {
            int[] numbers = parseArgumentsAndSort(args);
            String sortedNumbers = Arrays.toString(numbers);
            System.out.println("Sorted Numbers: " + sortedNumbers);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            SortingApp.printUsage();
        }
    }
}
