package uk.co.prient.adventofcode;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import uk.co.prient.adventofcode.SpiralDistanceCalculator.Coordinate;

public class SpiralDistanceCalculatorTest {
    private final SpiralDistanceCalculator calculator = new SpiralDistanceCalculator();

    @Test
    public void distance_from_zero_is_zero() {
        assertThat(calculator.calculateManhattanDistance(0, 0), is(0));
    }

    @Test
    public void distance_from_positive_coordinates_is_sum_of_coords() {
        assertThat(calculator.calculateManhattanDistance(10, 15), is(25));
    }

    @Test
    public void distance_from_negative_coordinates_is_sum_of_absolute_coords() {
        assertThat(calculator.calculateManhattanDistance(-10, -15), is(25));
    }

    @Test
    public void position_of_one_is_origin() {
        assertThat(calculator.walkSpiralPath(1), is(new Coordinate(0, 0)));
    }

    @Test
    public void position_of_two_is_right_one() {
        assertThat(calculator.walkSpiralPath(2), is(new Coordinate(1, 0)));
    }

    @Test
    public void position_of_three_is_right_one_and_up_one() {
        assertThat(calculator.walkSpiralPath(3), is(new Coordinate(1, 1)));
    }

    @Test
    public void position_of_ten_is_right_two_and_down_one() {
        assertThat(calculator.walkSpiralPath(10), is(new Coordinate(2, -1)));
    }

    @Test
    public void position_of_21_is_left_two_and_down_two() {
        assertThat(calculator.walkSpiralPath(21), is(new Coordinate(-2, -2)));
    }

    @Test
    public void position_of_2_spiralTotal_is_up_one_and_right_one() {
        assertThat(calculator.calculateSpiralTotals(2), is(new Coordinate(1, 1)));
    }

    @Test
    public void position_of_362_spiralTotal_is_down_two_and_left_two() {
        assertThat(calculator.calculateSpiralTotals(362), is(new Coordinate(-2, -2)));
    }

    @Test
    public void first_spiralTotal_over_362_is_362() {
        assertThat(calculator.calculateFirstSpiralTotalOverInput(362), is(362));
    }

}
