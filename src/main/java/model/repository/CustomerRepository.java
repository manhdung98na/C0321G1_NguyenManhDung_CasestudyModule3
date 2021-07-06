package model.repository;

import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {
    public List<Customer> selectAll();
    public boolean addCustomer(Customer customer);
    public boolean updateCustomer(Customer customer) throws SQLException;
    public Customer selectById(int id);
    public boolean deleteCustomer(int id) throws SQLException;
}
