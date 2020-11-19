package validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CarRightNumberValidator implements ConstraintValidator<CarRightNumber, String> {
    @Override
    public boolean isValid(String number, ConstraintValidatorContext context) {
        if(number.length() == 8) {
            int letters = 0, numbers = 0;
            for (int i = 0; i < 8; i++) {
                if(i < 2 || i > 5){
                    if(Character.isLetter(number.charAt(i)) && Character.isUpperCase(number.charAt(i))){
                        letters++;
                    }
                }
                else{
                    if(Character.isDigit(number.charAt(i))) {
                        numbers++;
                    }
                }
            }
            if(letters == 4 && numbers == 4){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
}
