package com.ua.hlibkorobov;


import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class SortingApp {

    /**
     * Parses the command-line arguments into an integer array.
     *
     * @param args the input arguments
     * @return an array of integers
     * @throws IllegalArgumentException if the number of arguments is invalid or parsing fails
     */
    public static int[] parseArgumentsAndSort(String[] args) throws IllegalArgumentException {
        if (args.length == 0) {
            throw new IllegalArgumentException("No arguments provided.");
        }
        if (args.length > 10) {
            throw new IllegalArgumentException("Too many arguments. Maximum allowed is 10.");
        }

        int[] numbers = new int[args.length];
        try {
            for (int i = 0; i < args.length; i++) {
                numbers[i] = Integer.parseInt(args[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("All arguments must be integers.");
        }

        Arrays.sort(numbers);
        return numbers;
    }

    /**
     * Prints the usage instructions for the application.
     */
    public static void printUsage() {
        String usage = "Usage: java -jar sorting-app.jar <num1> <num2> ... <num10>\n" +
                "Provide up to 10 integer arguments to sort in ascending order.";
        try {
            System.out.println(IOUtils.toString(URI.create(usage), StandardCharsets.UTF_8));
        } catch (IOException e) {
            // Fallback in case of an IOException
            System.out.println(usage);
        }
    }
}
