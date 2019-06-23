package pl.coderslab.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AdultValidator implements ConstraintValidator<Adult, Integer> {
    @Override
    public void initialize(Adult adult) {
    }

    @Override
    public boolean isValid(Integer yearOfBirth, ConstraintValidatorContext constraintValidatorContext) {
        return  LocalDate.now().getYear() - yearOfBirth >= 18;
    }
}
