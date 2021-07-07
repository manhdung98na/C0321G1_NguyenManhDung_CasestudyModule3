package model.repository.customer;

import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {
    public List<Customer> selectAll();

    public boolean addCustomer(Customer customer) throws SQLException;

    public boolean updateCustomer(Customer customer) throws SQLException;

    public Customer selectById(String id);

    public boolean deleteCustomer(String id) throws SQLException;

    public List<Customer> selectByName(String name) throws SQLException;

}
