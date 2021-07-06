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
                || ValidateCustomer.validateEmail(customer.getCustomerEmail()) != null
                || ValidateCustomer.validateID(customer.getCustomerId()) != null
                || ValidateCustomer.validateIdCard(customer.getCustomerIdCard()) != null) {
            mapError.put("nameError", ValidateCustomer.validateName(customer.getCustomerName()));
            mapError.put("phoneError", ValidateCustomer.validatePhoneNumber(customer.getCustomerPhone()));
            mapError.put("emailError", ValidateCustomer.validateEmail(customer.getCustomerEmail()));
            mapError.put("idError", ValidateCustomer.validateID(customer.getCustomerId()));
            mapError.put("idCardError", ValidateCustomer.validateIdCard(customer.getCustomerIdCard()));
        } else {
            try {
                customerRepository.addCustomer(customer);
            } catch (SQLException e) {
                String[] arr = e.getMessage().split(" ", 5);
                mapError.put("sqlError", arr[1] + " " + arr[2] + " " + arr[3]);
            }
        }
        return mapError;
    }

    @Override
    public List<Customer> selectAll() {
        return customerRepository.selectAll();
    }

    @Override
    public Map<String, String> updateCustomer(Customer customer) {
        Map<String, String> mapError = new HashMap<>();
        if (ValidateCustomer.validateName(customer.getCustomerName()) != null
                || ValidateCustomer.validatePhoneNumber(customer.getCustomerPhone()) != null
                || ValidateCustomer.validateEmail(customer.getCustomerEmail()) != null
                || ValidateCustomer.validateID(customer.getCustomerId()) != null
                || ValidateCustomer.validateIdCard(customer.getCustomerIdCard()) != null) {
            mapError.put("nameError", ValidateCustomer.validateName(customer.getCustomerName()));
            mapError.put("phoneError", ValidateCustomer.validatePhoneNumber(customer.getCustomerPhone()));
            mapError.put("emailError", ValidateCustomer.validateEmail(customer.getCustomerEmail()));
            mapError.put("idError", ValidateCustomer.validateID(customer.getCustomerId()));
            mapError.put("idCardError", ValidateCustomer.validateIdCard(customer.getCustomerIdCard()));
        } else {
            try {
                customerRepository.updateCustomer(customer);
            } catch (SQLException e) {
                String[] arr = e.getMessage().split(" ", 5);
                mapError.put("sqlError", arr[1] + " " + arr[2] + " " + arr[3]);
            }
        }
        return mapError;
    }

    @Override
    public Customer selectById(String id) {
        return customerRepository.selectById(id);
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public List<Customer> selectByName(String name) throws SQLException {
        return customerRepository.selectByName(name);
    }
}
