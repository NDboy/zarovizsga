package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {

    public int getNumberOfMales(String pathString) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(pathString))){
            return (int) br.lines()
                    .skip(1)
                    .filter(this::isMaleByLine)
                    .count();
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private boolean isMaleByLine(String lineString) {
        return "Male".equals(lineString.split(",")[4]);
    }
}
