package model.service.customer;

import common.ValidateCustomer;
import model.bean.Customer;
import model.repository.customer.CustomerRepositoryImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();

    @Override
    public Map<String, String> addCustomer(Customer customer) {
        Map<String, String> mapError = new HashMap<>();
        if (ValidateCustomer.validateName(customer.getCustomerName()) != null
                || ValidateCustomer.validatePhoneNumber(customer.getCustomerPhone()) != null
                || ValidateCustomer.validateEmail(customer.getCustomerEmail()) != null) {
            mapError.put("nameError", ValidateCustomer.validateName(customer.getCustomerName()));
            mapError.put("phoneError", ValidateCustomer.validatePhoneNumber(customer.getCustomerPhone()));
            mapError.put("emailError", ValidateCustomer.validateEmail(customer.getCustomerEmail()));
        } else {
            customerRepository.addCustomer(customer);
        }
        return mapError;
    }

    @Override
    public List<Customer> selectAll() {
        return customerRepository.selectAll();
    }

    @Override
    public Map<String, String> updateCustomer(Customer customer) throws SQLException {
        Map<String, String> mapError = new HashMap<>();
        if (ValidateCustomer.validateName(customer.getCustomerName()) != null
                || ValidateCustomer.validatePhoneNumber(customer.getCustomerPhone()) != null
                || ValidateCustomer.validateEmail(customer.getCustomerEmail()) != null) {
            mapError.put("nameError", ValidateCustomer.validateName(customer.getCustomerName()));
            mapError.put("phoneError", ValidateCustomer.validatePhoneNumber(customer.getCustomerPhone()));
            mapError.put("emailError", ValidateCustomer.validateEmail(customer.getCustomerEmail()));
        } else {
            customerRepository.updateCustomer(customer);
        }
        return mapError;

    }

    @Override
    public Customer selectById(int id) {
        return customerRepository.selectById(id);
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public List<Customer> selectByName(String name) {
        return customerRepository.selectByName(name);
    }
}
