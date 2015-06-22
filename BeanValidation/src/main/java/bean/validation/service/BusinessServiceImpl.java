package bean.validation.service;

import org.springframework.stereotype.Service;

import bean.validation.model.MessageBean;

@Service
public class BusinessServiceImpl implements BusinessService {
    
    public void performBusinessLogic(MessageBean messageBean){
	System.out.println("Doing business logic here !");
    }
}
