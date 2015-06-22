package bean.validation.validator.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValueSetConstraint  implements  ConstraintValidator<ValueSet, String>{
    
    private String[] values = null; 
    
    public void initialize(ValueSet constraintAnnotation) {
	values = constraintAnnotation.values();
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
	if(values != null && value != null && values.length >0){
	    for(String str : values){
		if(str.equalsIgnoreCase(value)){
		    return true;
		}
	    }
	}
	return false;
    }

}
