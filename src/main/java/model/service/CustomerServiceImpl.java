package model.service;

import model.bean.Customer;
import model.repository.CustomerRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
    @Override
    public boolean addCustomer(Customer customer) {
        return customerRepository.addCustomer(customer);
    }

    @Override
    public List<Customer> selectAll() {
        return customerRepository.selectAll();
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return customerRepository.updateCustomer(customer);
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
