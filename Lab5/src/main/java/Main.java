import exceptions.CarNotFoundException;
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
        User user1 = new User.Builder("Dima", "Holovach").setId(1).setAddress("gagarina 42").setBirthdate(LocalDate.of(2001, 06, 01)).build();
        User user2 = new User.Builder("Misha", "Holovach").setId(2).setAddress("gagarina 43").setBirthdate(LocalDate.of(2014, 11, 20)).build();
        Car car1 = new Car.Builder("DU5556CE").setBrand(Car.Brand.Mercedes).setYear(2020).setOwner(user1).build();
        Car car2 = new Car.Builder("CC1166CE").setBrand(Car.Brand.Porsche).setYear(2015).setOwner(user1).build();
        Car car3 = new Car.Builder("AO1111CE").setBrand(Car.Brand.BMW).setYear(2018).setOwner(user2).build();

        Car car4 = new Car();
        Car car5 = new Car();
        Car result_car = new Car();
        User result_user = new User();

        List<Car> Autoservice = Arrays.asList(car1, car2, car3);
        List<Car> Database_cars = new ArrayList<>();
        List<Car> Database_cars_sorted_by_number = new ArrayList<>();
        List<Car> Database_cars_sorted_by_year = new ArrayList<>();
        List<User> Database_users = new ArrayList<>();
        CarDatabase c = new CarDatabase();
        UserDatabase u = new UserDatabase();

        try {
            c.createTableCar();
            u.createTableUser();

            /*c.addCar(car1);
            c.addCar(car2);
            c.addCar(car3);
            u.addUser(user1);
            u.addUser(user2);*/

            result_car = c.getCarByFirstNumberSymbol("D");
            result_user = u.getUserWithCarList(1);
            //result_car = c.getById(1);

            //c.editCar(car3, 3);
            Database_cars = c.getAll();
            Database_cars_sorted_by_number = c.getCarsSortedByNumber();
            Database_cars_sorted_by_year = c.getCarsSortedByYear();
            //Database_users = u.getAll();
            //user2 = u.getById(1);
            //car4 = c.getById(1);
            //car5 = c.getByNumber("CC1166CE");
        }
        catch(SQLException | UserNotFoundException | CarNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }


        System.out.println("Get car by first number symbol: " + result_car);

        System.out.println("\nGet user with car list: " + result_user);

        System.out.println("\nStandard list:");
        for (Car car: Database_cars) {
            System.out.println(car);
        }
        System.out.println("\nList sorted by numbers:");
        for (Car car: Database_cars_sorted_by_number) {
            System.out.println(car);
        }
        System.out.println("\nList sorted by year:");
        for (Car car: Database_cars_sorted_by_year) {
            System.out.println(car);
        }

        //System.out.println(Database);
    }


}
