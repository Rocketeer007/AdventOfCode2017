package uk.co.prient.adventofcode;

import lombok.Data;

public class SpiralDistanceCalculator {
    public int calculateManhattanDistance(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }

    public int calculateSpiralDistance(int input) {
        Coordinate position = calculateSpiralPosition(input);
        return calculateManhattanDistance(position.x, position.y);
    }

    public Coordinate calculateSpiralPosition(int input) {
        /* I'm sure there's a mathematical solution to this... but I can't think of it! */
        /* For now, just use brute force and walk the path */
        int stepsRight = 1;
        int stepsUp = 1;
        int stepsLeft = 2;
        int stepsDown = 2;

        Coordinate position = new Coordinate(0, 0);
        Direction direction = Direction.RIGHT;
        int stepsTaken = 0;

        while (input > 1) {
            position = direction.takeStep(position);
            input--;
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
