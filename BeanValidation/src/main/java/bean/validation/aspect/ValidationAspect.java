package bean.validation.aspect;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.validation.model.MessageBean;

@Aspect
@Component
public class ValidationAspect {

    @Autowired
    private Validator validator;

    @Around("execution(public void bean.validation.service.BusinessService.performBusinessLogic(*))")
    public void performValidation(ProceedingJoinPoint proceedingJoinPoint) {
	Object[] args = proceedingJoinPoint.getArgs();
	MessageBean messageBean = (MessageBean) args[0];
	Set<ConstraintViolation<MessageBean>> constraintViolations = validator.validate(messageBean, Default.class);
	if (constraintViolations == null || constraintViolations.size() == 0) {
	    try {
		proceedingJoinPoint.proceed();
	    } catch (Throwable e) {
		e.printStackTrace();
	    }
	}else{
	    System.out.println("***proxy have found below validation errors ***");
	    
	    for (ConstraintViolation<MessageBean> constraintViolation : constraintViolations) {
		System.out.println(constraintViolation.getMessage());
	    }
	}
    }
}
