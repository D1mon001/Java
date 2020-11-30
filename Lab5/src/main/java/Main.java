import exceptions.UserNotFoundException;
import model.Car;
import model.User;
import postgreSQL.*;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static String pause() {
        System.out.println("Press Any Key To Continue...");
        return new java.util.Scanner(System.in).nextLine();
    }


    public static void main(String[] args) throws SQLException {

        Car car1 = new Car.Builder("DU5556CE").setBrand(Car.Brand.Mercedes).setYear(2020).setUser_id(1).build();
        Car car2 = new Car.Builder("CC1166CE").setBrand(Car.Brand.Porsche).setYear(2015).setUser_id(1).build();
        Car car3 = new Car.Builder("AO1111CE").setBrand(Car.Brand.BMW).setYear(2018).setUser_id(2).build();
        User user1 = new User.Builder("Dima", "Holovach").setAddress("gagarina 42").setBirthdate(LocalDate.of(2001, 06, 01)).build();
        User user2 = new User.Builder("Misha", "Holovach").setAddress("gagarina 43").setBirthdate(LocalDate.of(2014, 11, 20)).build();

        Car car4 = new Car();
        Car car5 = new Car();

        List<Car> Autoservice = Arrays.asList(car1, car2, car3);
        List<Car> Database_cars = new ArrayList<>();
        List<User> Database_users = new ArrayList<>();
        CarDatabase c = new CarDatabase();
        UserDatabase u = new UserDatabase();

        try {
            c.createTableCar();
            u.createTableUser();

            //u.addUser(user2);

            c.editCar(car3, 3);
            Database_cars = c.getAll();
            Database_users = u.getAll();
            //user2 = u.getById(1);
            //car4 = c.getById(1);
            //car5 = c.getByNumber("CC1166CE");
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        for (Car car: Database_cars) {
            System.out.println(car);
        }

        for (User user: Database_users) {
            System.out.println(user);
        }
        //System.out.println(Database);
        //System.out.println(user2);
    }


}
