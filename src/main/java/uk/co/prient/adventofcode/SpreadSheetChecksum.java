package uk.co.prient.adventofcode;

import static java.util.Arrays.asList;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    private boolean validateInput(String input) {
        return Pattern.matches("[\\d\\t\\n]+", input);
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

    public int calculateDivisorSum(String input) {
        if (!validateInputMultiple(input)) {
            throw new IllegalArgumentException("Expected input to consist of tab-separated number table with multiple entries per row");
        }

        int sum = 0;
        for (String line : input.split("\n")) {
            sum += calculateRowDivision(line);
        }
        return sum;
    }

    private int calculateRowDivision(String line) {
        List<BigDecimal> values = Arrays.stream(line.split("\t")).map(BigDecimal::new).collect(Collectors.toList());

        for (BigDecimal value1 : values) {
            for (BigDecimal value2 : values) {
                //noinspection NumberEquality - Deliberately skip when they're the exact same instance
                if (value1 == value2) continue;

                BigDecimal[] resultAndRemainder = value1.divideAndRemainder(value2);
                if (resultAndRemainder[1].equals(BigDecimal.ZERO)) {
                    return resultAndRemainder[0].intValue();
                }
            }
        }

        return 0;
    }

    private boolean validateInputMultiple(String input) {
        return Pattern.matches("(\\d+\\t\\d+(\\t\\d+)*\\n?)+", input);
    }
}
