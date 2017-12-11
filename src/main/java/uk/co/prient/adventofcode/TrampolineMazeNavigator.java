package uk.co.prient.adventofcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrampolineMazeNavigator {
    private final List<Integer> instructions;

    public TrampolineMazeNavigator(List<String> instructions) {
        this.instructions = instructions.stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    public int stepCount() {
        List<Integer> instructionsCopy = new ArrayList<>(instructions);

        int steps = 0;
        int position = 0;

        do {
            int action = instructionsCopy.get(position);
            instructionsCopy.set(position, action + 1);

            steps++;
            position += action;
        } while (position >= 0 && position < instructions.size());

        return steps;
    }
}
