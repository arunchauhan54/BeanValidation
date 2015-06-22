package bean.validation.validator.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TestConstraint  implements  ConstraintValidator<ValueShouldBeTest, String>{

    public void initialize(ValueShouldBeTest constraintAnnotation) {
	
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
	return value!= null && value.equalsIgnoreCase("Test");
    }

}
