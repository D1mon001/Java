package validators;
import model.*;
import org.jboss.logging.Logger;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class Validate {
    public Car validCar(Car car) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = (Validator) factory.getValidator();
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
        Logger log = Logger.getLogger(Car.class);
        for (ConstraintViolation<Car> violation : constraintViolations) {
            //log.error(violation.getMessage());
            //System.out.println(violation.getInvalidValue() + " " + violation.getConstraintDescriptor());
        }
        if (constraintViolations.size() == 0) {
            return car;
        }
        else {
            return null;
        }
    }
}
