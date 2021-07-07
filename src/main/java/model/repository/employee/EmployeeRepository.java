package model.repository.employee;

import model.bean.Customer;
import model.bean.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeRepository {
    public List<Employee> selectAll();

    public boolean addEmployee(Employee employee) throws SQLException;

    public boolean updateEmployee(Employee employee) throws SQLException;

    public Employee selectById(int id);

    public boolean deleteEmployee(int id) throws SQLException;

    public List<Employee> selectByName(String name);
}
