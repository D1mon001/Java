package comparators;

import model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseComparators {
    public List<Car> sortByCompareTo(List<Car> cars){
        cars.sort(Car::compareTo);
        return cars;
    }

    public List<Car> sortByCompareToWithStream(List<Car> cars){
        return cars.stream().sorted(Car::compareTo).collect(Collectors.toList());
    }

    public List<Car> sortByYear(List<Car> cars){
        cars.sort(new CarYearComparator());
        return cars;
    }

    public List<Car> sortByYearWithStream(List<Car> cars){
        return cars.stream().sorted(new CarYearComparator()).collect(Collectors.toList());
    }

    public List<Car> sortByNumber(List<Car> cars){
        cars.sort(new CarNumberComparator());
        return cars;
    }

    public List<Car> sortByNumberWithStream(List<Car> cars){
        return cars.stream().sorted(new CarNumberComparator()).collect(Collectors.toList());
    }

    public List<Car> numberContainsSymbol(List<Car> cars, String x){
        List<Car> result = new ArrayList<>();
        for (Car car: cars) {
            if(car.getNumber().contains(x)){
                result.add(car);
            }
        }
        return result;
    }

    public Car searchByNumber(List<Car> cars, String number){
        for (Car car: cars){
            if(car.getNumber() == number){
                return car;
            }
        }
        return null;
    }
}
