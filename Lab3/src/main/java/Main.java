import model.Car;
import model.User;
import comparators.UseComparators;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UseComparators c = new UseComparators();

        Car car1 = new Car.Builder("DU1454CE").setBrand(Car.Brand.Mercedes).setYear(2010).build();
        Car car2 = new Car.Builder("CC1166CE").setBrand(Car.Brand.Porsche).setYear(2015).build();
        Car car3 = new Car.Builder("AO1111CE").setBrand(Car.Brand.BMW).setYear(2018).build();
        User user1 = new User.Builder("Dima", "Holovach").setAddress("gagarina 42").setBirthdate(LocalDate.of(2001, 06, 01)).setTransports(List.of(car1, car2, car3)).build();

        Car car4 = new Car(Car.Brand.Volkswagen, "BU4545CE", 2010);

        List<Car> Autoservice = Arrays.asList(car1, car2, car3, car4);


        System.out.println("Sorted cars:");
        c.sortByCompareTo(Autoservice).forEach(a -> System.out.println("\t" + a));

        System.out.println("\nSorted cars by year:");
        c.sortByYear(Autoservice).forEach(a -> System.out.println("\t" + a));

        System.out.println("\nSorted cars by number:");
        c.sortByNumber(Autoservice).forEach(a -> System.out.println("\t" + a));

        String number = "AO1111CE";
        System.out.println("\nSearch car by number: " + number);
        System.out.println(c.searchByNumber(Autoservice, number));

        System.out.println("\nSearch cars by numbers that have symbol:");
        c.numberContainsSymbol(Autoservice, "1").forEach(a -> System.out.println("\t" + a));
    }
}
