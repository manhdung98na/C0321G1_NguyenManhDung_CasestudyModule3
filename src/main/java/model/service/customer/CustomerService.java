package model.service.customer;

import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface CustomerService {
    public List<Customer> selectAll();

    public Map<String, String> addCustomer(Customer customer);

    public Map<String, String> updateCustomer(Customer customer);

    public Customer selectById(String id);

    public boolean deleteCustomer(String id) throws SQLException;

    public List<Customer> selectByName(String name) throws SQLException;
}
