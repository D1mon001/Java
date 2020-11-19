import model.*;
import validators.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.jboss.logging.Logger;
import java.util.Set;


public class Main {

    public static void main(String[] args) {
        Validate val = new Validate();

        //Correct build
        Car car1 = val.validCar(new Car.Builder("DU5454CE").setBrand(Car.Brand.Mercedes).setYear(2010).build());
        System.out.println(car1);

        //Incorrect build
        Car car2 = val.validCar(new Car.Builder("DU454CE").setBrand(Car.Brand.BMW).setYear(2021).build());
        System.out.println(car2);
    }
}
