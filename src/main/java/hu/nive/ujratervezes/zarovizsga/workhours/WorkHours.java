package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

public class WorkHours {


    public String minWork(String file) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(file))){
            EmployeeReg foundEmployeeReg = br.lines()
                    .map(this::processLineToEmployeeReg)
                    .min(Comparator.comparing(EmployeeReg::getHours))
                    .orElseThrow(() -> new IllegalArgumentException("Not found"));
            return buildStringFromEmployeeReg(foundEmployeeReg);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private EmployeeReg processLineToEmployeeReg(String lineString) {
        String[] lineArray = lineString.split(",");
        String name = lineArray[0];
        int hour = Integer.parseInt(lineArray[1]);
        String day = lineArray[2];
        return new EmployeeReg(name, hour, day);
    }

    private String buildStringFromEmployeeReg(EmployeeReg employeeReg) {
        return String.format("%s: %s", employeeReg.getName(), employeeReg.getDay());
    }

}
