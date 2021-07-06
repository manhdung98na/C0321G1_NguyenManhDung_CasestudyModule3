package model.service.customer;

import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface CustomerService {
    public List<Customer> selectAll();
    public Map<String,String> addCustomer(Customer customer);
    public Map<String,String> updateCustomer(Customer customer) throws SQLException;
    public Customer selectById(int id);
    public boolean deleteCustomer(int id) throws SQLException;
    public List<Customer> selectByName(String name);
}
