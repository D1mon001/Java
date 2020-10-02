import model.Car;
import model.User;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        User user1 = new User.Builder("Dima", "Golovaci").setAddress("Cernivtsi").setBirthdate(LocalDate.of(2001, 06, 01)).build();
        Car car = new Car.Builder("AU3454CE").setBrand(Car.Brand.Audi).setYear(2010).setOwner(user1).build();
        System.out.println(car);
        //System.out.println(user1);

        //System.out.println(user1.equals(user2));
    }
}
