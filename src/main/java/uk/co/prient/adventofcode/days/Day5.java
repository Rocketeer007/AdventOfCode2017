package uk.co.prient.adventofcode.days;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import uk.co.prient.adventofcode.TrampolineMazeNavigator;

public class Day5 {
    public static void main(String[] args) {
        String filename = "target/classes/Input-Day5.txt";
        if (args.length > 0) {
            filename = args[0];
        }
        Path inputFile = new File(filename).toPath();

        try (Stream<String> stream = Files.lines(inputFile)) {
            TrampolineMazeNavigator navigator = new TrampolineMazeNavigator(stream.collect(Collectors.toList()));
            System.out.println("Steps to exit - easy: " + navigator.stepCount(navigator.incrementAction));
            System.out.println("Steps to exit - hard: " + navigator.stepCount(navigator.offsetAction));
        } catch (IOException ioe) {
            System.err.println("Exception: "+ioe.getMessage());
            ioe.printStackTrace();
            System.err.println("Processing file: "+inputFile.toAbsolutePath().toString());
        }
    }
}
