package validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = CarRightNumberValidator.class)
public @interface CarRightNumber {
    String message() default "{Number has incorrect format!}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}