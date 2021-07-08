package model.service;

import model.bean.CustomerUsingService;
import model.repository.HomepageRepository;

import java.util.List;

public class HomepageService {
    public static List<CustomerUsingService> seselectCustomerUsingService(){
        return HomepageRepository.selectCustomerUsingService();
    }
}
