package model.service.customer;

import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    public List<Customer> selectAll();
    public boolean addCustomer(Customer customer);
    public boolean updateCustomer(Customer customer) throws SQLException;
    public Customer selectById(int id);
    public boolean deleteCustomer(int id) throws SQLException;
    public List<Customer> selectByName(String name);
}
