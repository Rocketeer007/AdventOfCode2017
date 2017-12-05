package uk.co.prient.adventofcode;

import java.util.regex.Pattern;

public class SpreadSheetChecksum {
    public int calculateChecksum(String input) {
        if (!validateInput(input)) {
            throw new IllegalArgumentException("Expected input to consist of tab-separated number table");
        }

        int sum = 0;
        for (String line : input.split("\n")) {
            sum += calculateRowDifference(line);
        }
        return sum;
    }

    private int calculateRowDifference(String line) {
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;

        for (String number : line.split("\t")) {
            Integer value = Integer.valueOf(number);
            if (value > maximum) maximum = value;
            if (value < minimum) minimum = value;
        }

        return maximum - minimum;
    }

    private boolean validateInput(String input) {
        return Pattern.matches("[\\d\\t\\n]+", input);
    }
}
