package uk.co.prient.adventofcode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TrampolineMazeNavigator {
    private final List<Integer> instructions;

    public TrampolineMazeNavigator(List<String> instructions) {
        this.instructions = instructions.stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    public int stepCount(Function<Integer, Integer> stepAction) {
        List<Integer> instructionsCopy = new ArrayList<>(instructions);

        int steps = 0;
        int position = 0;

        do {
            int action = instructionsCopy.get(position);
            instructionsCopy.set(position, stepAction.apply(action));

            steps++;
            position += action;
        } while (position >= 0 && position < instructions.size());

        return steps;
    }

    public final Function<Integer, Integer> incrementAction = action -> action + 1;

    public final Function<Integer, Integer> offsetAction = action -> (action >= 3 ? action - 1 : action + 1);
}
