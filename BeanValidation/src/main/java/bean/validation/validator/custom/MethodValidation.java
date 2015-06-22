package bean.validation.validator.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=MethodValidation.Validator.class)
public @interface MethodValidation {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message() default " Validation on method failed !";

    @SupportedValidationTarget(ValidationTarget.PARAMETERS)
    public static class Validator implements ConstraintValidator<MethodValidation, Object []>  {

	public void initialize(MethodValidation constraintAnnotation) {
	}

	public boolean isValid(Object [] values, ConstraintValidatorContext context) {
	    for(Object value : values)
	    System.out.println(value);
	    
	    return false;
	}

    }
    
    

}
