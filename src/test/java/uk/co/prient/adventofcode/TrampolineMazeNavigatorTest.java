package uk.co.prient.adventofcode;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.function.Function;

import org.junit.Test;

public class TrampolineMazeNavigatorTest {
    @Test
    public void given_an_integer_incrementAction_returns_value_plus_one() {
        Function<Integer, Integer> incrementAction = new TrampolineMazeNavigator(asList("1")).incrementAction;

        assertThat(incrementAction.apply(1), is(2));
    }

    @Test
    public void given_an_integer_over_3_offsetAction_returns_value_minus_one() {
        Function<Integer, Integer> offsetAction = new TrampolineMazeNavigator(asList("1")).offsetAction;

        assertThat(offsetAction.apply(3), is(2));
    }

    @Test
    public void given_an_integer_under_3_offsetAction_returns_value_plus_one() {
        Function<Integer, Integer> offsetAction = new TrampolineMazeNavigator(asList("1")).offsetAction;

        assertThat(offsetAction.apply(2), is(3));
    }

    @Test
    public void given_a_single_positive_step_then_stepCount_is_one() {
        TrampolineMazeNavigator navigator = new TrampolineMazeNavigator(asList("1"));

        assertThat(navigator.stepCount(navigator.incrementAction), is(1));
    }

    @Test
    public void given_a_single_negative_step_then_stepCount_is_one() {
        TrampolineMazeNavigator navigator = new TrampolineMazeNavigator(asList("-1"));

        assertThat(navigator.stepCount(navigator.incrementAction), is(1));
    }

    @Test
    public void given_a_single_zero_step_then_stepCount_is_two() {
        TrampolineMazeNavigator navigator = new TrampolineMazeNavigator(asList("0"));

        assertThat(navigator.stepCount(navigator.incrementAction), is(2));
    }

    @Test
    public void given_multiple_steps_then_stepCount_is_correct() {
        TrampolineMazeNavigator navigator = new TrampolineMazeNavigator(asList("0", "3", "0", "1", "-3"));

        assertThat(navigator.stepCount(navigator.incrementAction), is(5));
    }
}
