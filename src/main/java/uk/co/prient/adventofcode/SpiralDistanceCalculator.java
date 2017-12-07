package uk.co.prient.adventofcode;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import lombok.Data;

public class SpiralDistanceCalculator {
    private final Map<Coordinate, Integer> spiralPath = new HashMap<>();

    public int calculateSpiralDistance(int input) {
        Coordinate position = walkSpiralPath(input, this::saveStepCount);
        return calculateManhattanDistance(position.x, position.y);
    }

    public int calculateFirstSpiralTotalOverInput(int input) {
        Coordinate position = walkSpiralPath(input, this::savePositionTotal);
        return spiralPath.get(position);
    }

    protected int calculateManhattanDistance(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }

    private void saveStepCount(int stepCount, Coordinate position) {
        spiralPath.put(position, stepCount+1);
    }

    private void savePositionTotal(int stepCount, Coordinate position) {
        int positionTotal = 0;
        for (int xOffset = -1; xOffset <= 1; xOffset++) {
            for (int yOffset = -1; yOffset <= 1; yOffset++) {
                positionTotal += spiralPath.getOrDefault(new Coordinate(position.x + xOffset, position.y + yOffset), 0);
            }
        }
        if (positionTotal == 0) positionTotal = 1;
        spiralPath.put(position, positionTotal);
    }

    protected Coordinate calculateSpiralTotals(int limitValue) {
        return walkSpiralPath(limitValue, this::savePositionTotal);
    }

    protected Coordinate walkSpiralPath(int stepCount) {
        return walkSpiralPath(stepCount, this::saveStepCount);
    }

    private Coordinate walkSpiralPath(int maxPositionValue, BiConsumer<Integer, Coordinate> stepAction) {
        /* I'm sure there's a mathematical solution to this... but I can't think of it! */
        /* For now, just use brute force and walk the path */
        int stepsRight = 1;
        int stepsUp = 1;
        int stepsLeft = 2;
        int stepsDown = 2;

        Coordinate position = new Coordinate(0, 0);
        Direction direction = Direction.RIGHT;
        int stepsTaken = 0;
        int totalStepsTaken = 0;

        while (true) {
            stepAction.accept(totalStepsTaken, position);
            if (spiralPath.get(position) >= maxPositionValue)
                break;
            totalStepsTaken++;

            position = direction.takeStep(position);
            stepsTaken++;

            switch (direction) {
                case RIGHT:
                    if (stepsTaken >= stepsRight) {
                        stepsTaken = 0;
                        stepsRight += 2;
                        direction = direction.nextDirection();
                    }
                    break;
                case UP:
                    if (stepsTaken >= stepsUp) {
                        stepsTaken = 0;
                        stepsUp += 2;
                        direction = direction.nextDirection();
                    }
                    break;
                case LEFT:
                    if (stepsTaken >= stepsLeft) {
                        stepsTaken = 0;
                        stepsLeft += 2;
                        direction = direction.nextDirection();
                    }
                    break;
                case DOWN:
                    if (stepsTaken >= stepsDown) {
                        stepsTaken = 0;
                        stepsDown += 2;
                        direction = direction.nextDirection();
                    }
                    break;
            }
        }
        return position;
    }

    @Data
    public static class Coordinate {
        private final int x;
        private final int y;
    }

    private enum Direction {
        RIGHT, UP, LEFT, DOWN;

        public Direction nextDirection() {
            switch (this) {
                case RIGHT: return UP;
                case UP: return LEFT;
                case LEFT: return DOWN;
                case DOWN: return RIGHT;
            }
            return this;
        }

        public Coordinate takeStep(Coordinate from) {
            switch (this) {
                case RIGHT: return new Coordinate(from.x + 1, from.y);
                case UP: return new Coordinate(from.x, from.y + 1);
                case LEFT: return new Coordinate(from.x - 1, from.y);
                case DOWN: return new Coordinate(from.x, from.y - 1);
            }
            return from;
        }
    }
}
