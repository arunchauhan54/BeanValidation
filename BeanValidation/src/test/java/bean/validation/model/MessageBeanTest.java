package bean.validation.model;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

import org.junit.BeforeClass;
import org.junit.Test;

import bean.validation.group.ChildValidationGroup;
import bean.validation.group.FirstValidationGroup;
import bean.validation.group.ValidationSequence;

public class MessageBeanTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	validator = factory.getValidator();
    }

    @Test
    public void testDefaultGroup() {
	MessageBean arg0 = new MessageBean(null, "t", "5");
	Set<ConstraintViolation<MessageBean>> violations = validator.validate(arg0, Default.class);
	for (ConstraintViolation<MessageBean> violation : violations) {
	    System.out.println(violation.getMessage());

	}

    }

    @Test
    public void testFirstValidationGroup() {
	MessageBean arg0 = new MessageBean(null, "t", "5");
	Set<ConstraintViolation<MessageBean>> violations = validator.validate(arg0, FirstValidationGroup.class);
	for (ConstraintViolation<MessageBean> violation : violations) {
	    System.out.println(violation.getMessage());

	}

    }

    @Test
    public void testChildValidationGroup() {
	MessageBean arg0 = new MessageBean(null, "t", "5");
	Set<ConstraintViolation<MessageBean>> violations = validator.validate(arg0, ChildValidationGroup.class);
	for (ConstraintViolation<MessageBean> violation : violations) {
	    System.out.println(violation.getMessage());

	}

    }

    @Test
    public void testGroupsSequence() {
	MessageBean arg0 = new MessageBean(null, "t", "5");
	Set<ConstraintViolation<MessageBean>> violations = validator.validate(arg0, ValidationSequence.class);
	for (ConstraintViolation<MessageBean> violation : violations) {
	    System.out.println(violation.getMessage());
	}

    }

    //below methods will be supported only with hibernate validator 5 version.
   /* @Test
    public void testMethodParameter() {
	try {
	    ExecutableValidator executableValidator = validator.forExecutables();
	    MessageBean bean = new MessageBean("test", "test", "5");
	    Method method;
	    method = MessageBean.class.getMethod("validateMe", String.class);
	    Set<ConstraintViolation<MessageBean>> violations = executableValidator.validateParameters(bean, method, new Object[] {null}, Default.class);
	    for (ConstraintViolation<MessageBean> violation : violations) {
		    System.out.println(violation.getMessage());
		}
	} catch (SecurityException e) {
	    e.printStackTrace();
	} catch (NoSuchMethodException e) {
	    e.printStackTrace();
	}
    }
    
    @Test
    public void testCustomReturnTypeValidation(){
	
	try {
	    ExecutableValidator executableValidator = validator.forExecutables();
	    MessageBean bean = new MessageBean("test", "dddd", "5");
	    Method method;
	    method = MessageBean.class.getMethod("customReturnTypeValidation", String.class,String.class);
	    Set<ConstraintViolation<MessageBean>> violations = executableValidator.validateReturnValue(bean, method, "test",Default.class);
	    for (ConstraintViolation<MessageBean> violation : violations) {
		System.out.println(violation.getMessage());
	    }
	} catch (SecurityException e) {
	    e.printStackTrace();
	} catch (NoSuchMethodException e) {
	    e.printStackTrace();
	}
    }
    
    
    
    @Test
    public void testCustomValidation(){
	
	try {
	    ExecutableValidator executableValidator = validator.forExecutables();
	    MessageBean bean = new MessageBean("test", "dddd", "5");
	    Method method;
	    method = MessageBean.class.getMethod("customValidation", String.class,String.class);
	    Set<ConstraintViolation<MessageBean>> violations = executableValidator.validateParameters(bean, method,new String[] {"test","test1"},Default.class);
	    for (ConstraintViolation<MessageBean> violation : violations) {
		System.out.println(violation.getMessage());
	    }
	} catch (SecurityException e) {
	    e.printStackTrace();
	} catch (NoSuchMethodException e) {
	    e.printStackTrace();
	}
    }*/
    
    

}
