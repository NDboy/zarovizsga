package hu.nive.ujratervezes.zarovizsga.words;

public class Words {
    public boolean hasMoreDigits(String s) {
        long counter = s.chars()
                .filter(Character::isDigit)
                .count();
        return counter * 2 > s.length();
    }
}
