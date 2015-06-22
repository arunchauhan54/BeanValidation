package bean.validation.validator.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=MethodReturnTypeValidation.Validator.class)
public @interface MethodReturnTypeValidation {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message() default "Validation on method return type failed";



    public static class Validator implements ConstraintValidator<MethodReturnTypeValidation, String>  {

	public void initialize(MethodReturnTypeValidation constraintAnnotation) {
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
	    return false;
	}

    }
    
    

}
