package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kennel {


    private final List<Dog> dogs = new ArrayList<>();

    public List<Dog> getDogs() {
        return dogs;
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void feedAll() {
        dogs.forEach(Dog::feed);
    }

    public Dog findByName(String name) {
        return dogs.stream()
                .filter(a -> name.equals(a.getName()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Dog not found"));
    }

    public void playWith(String name, int hours) {
        dogs.stream()
                .filter(a -> name.equals(a.getName()))
                .forEach(a -> a.play(hours));
    }

    public List<String> getHappyDogNames(int minHappiness) {
        return dogs.stream()
                .filter(a -> a.getHappiness() > minHappiness)
                .map(Dog::getName)
                .collect(Collectors.toList());
    }

}
