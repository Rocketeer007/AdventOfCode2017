package uk.co.prient.adventofcode.days;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import uk.co.prient.adventofcode.PassphraseValidator;

public class Day4 {
    public static void main(String[] args) {
        String filename = "target/classes/Input-Day4.txt";
        if (args.length > 0) {
            filename = args[0];
        }
        Path inputFile = new File(filename).toPath();

        PassphraseValidator passphraseValidator = new PassphraseValidator();

        try (Stream<String> stream = Files.lines(inputFile)) {
            System.out.println("Valid passphrases: "+stream.filter(passphraseValidator::verifyUniqueWords).count());
        } catch (IOException ioe) {
            System.err.println("Exception: "+ioe.getMessage());
            ioe.printStackTrace();
            System.err.println("Processing file: "+inputFile.toAbsolutePath().toString());
        }
    }
}
