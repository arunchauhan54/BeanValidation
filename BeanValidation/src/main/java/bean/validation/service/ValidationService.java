package bean.validation.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.validation.model.MessageBean;

@Service
public class ValidationService {
    
    @Autowired
    private Validator validator;
    
    public Set<ConstraintViolation<MessageBean>> performValidation(MessageBean bean){
	Set<ConstraintViolation<MessageBean>> errors=  validator.validate(bean, Default.class);
	return errors;
    }
    
}
