package uk.co.prient.adventofcode.days;

import uk.co.prient.adventofcode.SpiralDistanceCalculator;

public class Day3 {
    public static void main(String[] args) {
        int input = 361527;
        if (args.length > 0) {
            input = Integer.valueOf(args[0]);
        }

        SpiralDistanceCalculator calculator = new SpiralDistanceCalculator();
        System.out.println(String.format("Position: %d", input));
        System.out.println(String.format("Manhattan Distance: %d", calculator.calculateSpiralDistance(input)));
        calculator = new SpiralDistanceCalculator();
        System.out.println(String.format("First Larger Spiral Total: %d", calculator.calculateFirstSpiralTotalOverInput(input)));
    }
}
