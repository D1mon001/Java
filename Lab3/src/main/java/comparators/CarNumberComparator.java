package comparators;

import model.Car;

import java.util.Comparator;

public class CarNumberComparator implements Comparator<Car> {
    @Override
    public int compare(Car a1, Car a2) {
        return a1.getNumber().compareTo(a2.getNumber());
    }
}
