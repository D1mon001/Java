package comparators;

import model.Car;

import java.util.Comparator;


public class CarYearComparator implements Comparator<Car> {
    @Override
    public int compare(Car a1, Car a2) {
        return a1.getYear() - a2.getYear();
    }
}
