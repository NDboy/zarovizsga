package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public int cleanAll() {
        int sum = cleanables.stream()
                .map(Cleanable::clean)
                .mapToInt(Integer::intValue)
                .sum();
        cleanables.clear();
        return sum;
    }

    public List<Cleanable> getCleanables() {
        return cleanables;
    }

    public int cleanOnlyOffices() {
        List<Cleanable> copyList = new ArrayList<>(cleanables);
        int sum = cleanables.stream()
                .filter(a -> a instanceof Office)
                .mapToInt(Cleanable::clean).sum();
        copyList.stream()
                .filter(a -> a instanceof Office)
                .forEach(a -> cleanables.remove(a));
        return sum;
    }

    public List<Cleanable> findByAddressPart(String address) {
        return cleanables.stream()
                .filter(a -> a.getAddress().contains(address))
                .collect(Collectors.toList());
    }

    public String getAddresses() {
        return cleanables.stream()
                .map(Cleanable::getAddress)
                .collect(Collectors.joining(", "));
    }

}
