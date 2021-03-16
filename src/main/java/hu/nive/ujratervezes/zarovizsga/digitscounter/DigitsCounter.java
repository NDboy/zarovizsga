package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {

    public int getCountOfDigits(String numberString) {
        if (numberString == null) {
            return 0;
        }
        Set<Integer> digits = new HashSet<>();
        for (int i = 0; i < numberString.length(); i++) {
            if (parseDigit(numberString.charAt(i)) != null) {
                digits.add(parseDigit(numberString.charAt(i)));
            }
        }
        return digits.size();
    }

    private Integer parseDigit(char c) {
        if (Character.isDigit(c)) {
            return Integer.parseInt(String.valueOf(c));
        }
        return null;
    }

}
