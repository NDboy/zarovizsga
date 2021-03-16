package hu.nive.ujratervezes.zarovizsga.digitscounter;


import java.util.stream.IntStream;

public class DigitsCounter {

    public int getCountOfDigits(String numberString) {
        if (numberString == null) {
            return 0;
        }
        return (int)IntStream.range(0, numberString.length())
                .map(numberString::charAt)
                .distinct()
                .filter(Character::isDigit)
                .count();
    }


}
