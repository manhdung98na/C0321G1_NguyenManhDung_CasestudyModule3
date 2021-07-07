package model.service.employee;

import model.bean.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public List<Employee> selectAll();

    public Map<String, String> addEmployee(Employee employee);

    public Map<String, String> updateEmployee(Employee employee);

    public Employee selectById(int id);

    public boolean deleteEmployee(int id) throws SQLException;

    public List<Employee> selectByName(String name);
}
