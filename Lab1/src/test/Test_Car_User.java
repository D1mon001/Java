package test;

import model.Car;
import model.User;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class Test_Car_User {
    @Test
    public void massTest() {
        assertEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});
    }


    public void carEquals(){
        User user1 = new User.Builder("Dima", "Golovaci").setAddress("Cernivtsi").setBirthdate(LocalDate.of(2001, 06, 01)).build();
        User user2 = new User.Builder("Sasha", "Schur").setAddress("Cernivtsi").setBirthdate(LocalDate.of(2001, 07, 20)).build();
        Car car1 = new Car.Builder("AU1234CE").setBrand(Car.Brand.Audi).setYear(2010).setOwner(user1).build();
        Car car2 = new Car.Builder("AU1234CE").setBrand(Car.Brand.Audi).setYear(2010).setOwner(user2).build();
        assertEquals(car1, car2);
    }

    @Test(dataProvider = "notEqualsCarObject")
    public void carNotEquals(Car car1, Car car2) {
        //assertTrue(car1.equals(car2));
        //assertEquals(car1, car2);
        assertNotEquals(car1, car2);
    }

    @DataProvider
    public Object[][] notEqualsCarObject() {
        User user1 = new User.Builder("Dima", "Golovaci").setAddress("Cernivtsi").setBirthdate(LocalDate.of(2001, 06, 01)).build();
        User user2 = new User.Builder("Sasha", "Schur").setAddress("Cernivtsi").setBirthdate(LocalDate.of(2001, 07, 20)).build();
        Car car1 = new Car.Builder("AU1234CE").setBrand(Car.Brand.Audi).setYear(2010).setOwner(user1).build();
        Car car2 = new Car.Builder("AU3454CE").setBrand(Car.Brand.Audi).setYear(2010).setOwner(user2).build();
        Car car3 = new Car.Builder("AU1234CE").setBrand(Car.Brand.Mercedes).setYear(2010).setOwner(user1).build();
        Car car4 = new Car.Builder("AU1234CE").setBrand(Car.Brand.Audi).setYear(2015).setOwner(user1).build();
        return new Object[][]{{car1, car2}, {car1, car3}, {car1, car4}};
    }

    public void userEquals(){
        User user1 = new User.Builder("Dima", "Golovaci").setAddress("Cernivtsi").setBirthdate(LocalDate.of(2001, 06, 01)).build();
        User user2 = new User.Builder("Dima", "Golovaci").setAddress("Ternopil").setBirthdate(LocalDate.of(2001, 07, 20)).build();
        assertEquals(user1, user2);
    }
    
    @Test(dataProvider = "notEqualsUserObject")
    public void userNotEquals(User user1, User user2) {
        //assertEquals(user1, user2);
        assertNotEquals(user1, user2);
    }

    @DataProvider
    public Object[][] notEqualsUserObject() {
        User user1 = new User.Builder("Dima", "Golovaci").setAddress("Cernivtsi").setBirthdate(LocalDate.of(2001, 06, 01)).build();
        User user2 = new User.Builder("Andreu", "Golovaci").setAddress("Cernivtsi").setBirthdate(LocalDate.of(2001, 06, 01)).build();
        User user3 = new User.Builder("Dima", "Madei").setAddress("Cernivtsi").setBirthdate(LocalDate.of(2001, 06, 01)).build();
        User user4 = new User.Builder("Dima", "Golovaci").setAddress("Cernivtsi").setBirthdate(LocalDate.of(2001, 07, 20)).build();
        return new Object[][]{{user1, user2}, {user1, user3}, {user1, user4}};
    }

}
