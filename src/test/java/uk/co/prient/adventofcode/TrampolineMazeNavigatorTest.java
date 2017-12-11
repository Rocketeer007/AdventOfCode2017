package uk.co.prient.adventofcode;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TrampolineMazeNavigatorTest {
    @Test
    public void given_a_single_positive_step_then_stepCount_is_one() {
        TrampolineMazeNavigator navigator = new TrampolineMazeNavigator(asList("1"));

        assertThat(navigator.stepCount(), is(1));
    }

    @Test
    public void given_a_single_negative_step_then_stepCount_is_one() {
        TrampolineMazeNavigator navigator = new TrampolineMazeNavigator(asList("-1"));

        assertThat(navigator.stepCount(), is(1));
    }

    @Test
    public void given_a_single_zero_step_then_stepCount_is_two() {
        TrampolineMazeNavigator navigator = new TrampolineMazeNavigator(asList("0"));

        assertThat(navigator.stepCount(), is(2));
    }

    @Test
    public void given_multiple_steps_then_stepCount_is_correct() {
        TrampolineMazeNavigator navigator = new TrampolineMazeNavigator(asList("0", "3", "0", "1", "-3"));

        assertThat(navigator.stepCount(), is(5));
    }
}
