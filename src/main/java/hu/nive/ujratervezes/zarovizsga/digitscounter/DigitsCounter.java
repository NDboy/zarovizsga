package hu.nive.ujratervezes.zarovizsga.digitscounter;

public class DigitsCounter {

    public int getCountOfDigits(String numberString) {
        if (numberString == null) {
            return 0;
        }
        return (int)numberString.chars()
                .distinct()
                .filter(Character::isDigit)
                .count();
    }


}
