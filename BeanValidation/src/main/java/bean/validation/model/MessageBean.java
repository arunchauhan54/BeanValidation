package bean.validation.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import bean.validation.group.ChildValidationGroup;
import bean.validation.group.FirstValidationGroup;
import bean.validation.validator.custom.MethodReturnTypeValidation;
import bean.validation.validator.custom.MethodValidation;
import bean.validation.validator.custom.ValueSet;
import bean.validation.validator.custom.ValueShouldBeTest;


public class MessageBean {
    
        @ValueShouldBeTest
    	@NotNull
	private String field1;
	
        @ValueSet(values={"aa","bb","ccc","dddd"})
	@Size(min=2, max=4, groups=FirstValidationGroup.class)
	private String field2;

	@Max(value=4, groups=ChildValidationGroup.class)
	private String field3;
	
	public MessageBean(String field1,String field2,String field3) {
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}
	
	@MethodValidation
	public String customValidation(String str1,String str2){
	    return str1;
	}
	
	@MethodReturnTypeValidation
	public String customReturnTypeValidation(String str1,String str2){
	    return str1;
	}
	
	public String validateMe(@NotNull String str){
	    return str;
	}


	public String getField1() {
	    return field1;
	}

	public String getField2() {
	    return field2;
	}

	public String getField3() {
	    return field3;
	}

}
