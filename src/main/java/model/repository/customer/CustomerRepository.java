package model.repository.customer;

import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {
    public List<Customer> selectAll();

    public boolean addCustomer(Customer customer) throws SQLException;

    public boolean updateCustomer(Customer customer) throws SQLException;

    public Customer selectById(String id);

    boolean isPhoneExist(String id);

    boolean isEmailExist(String idCard);

    public boolean deleteCustomer(String id) throws SQLException;

    Customer selectByIdCard(String id);

    Customer selectByPhone(String phone);

    Customer selectByEmail(String email);

    public List<Customer> selectByName(String name) throws SQLException;

    public boolean isIdExist(String id);

    public boolean isIdCardExist(String idCard);

}
