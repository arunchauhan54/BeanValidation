package bean.validation.main;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.validation.model.MessageBean;
import bean.validation.service.BusinessService;
import bean.validation.service.ValidationService;

public class SpringStarter {
    public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//	directCallForValidation(context);
	usingAOPForValidation(context);
    }

    private static void directCallForValidation(ApplicationContext context) {
	ValidationService validationService = context.getBean(ValidationService.class);
	MessageBean messageBean = new MessageBean(null, "a", "4");
	Set<ConstraintViolation<MessageBean>> constraintViolations = validationService.performValidation(messageBean);
	for(ConstraintViolation<MessageBean> constraintViolation : constraintViolations){
	    System.out.println(constraintViolation.getMessage());
	}
    }
    
    private static void usingAOPForValidation(ApplicationContext context) {
  	BusinessService businessService = context.getBean(BusinessService.class);
  	MessageBean messageBean = new MessageBean(null, "aa", "4");
  	businessService.performBusinessLogic(messageBean);
   }

}
