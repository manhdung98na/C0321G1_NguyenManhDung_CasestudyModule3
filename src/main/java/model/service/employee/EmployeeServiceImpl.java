package model.service.employee;

import common.ValidateCustomer;
import model.bean.Employee;
import model.repository.employee.EmployeeRepositoryImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepositoryImpl repository = new EmployeeRepositoryImpl();

    @Override
    public List<Employee> selectAll() {
        return repository.selectAll();
    }

    @Override
    public Map<String, String> addEmployee(Employee employee) {
        Map<String, String> mapError = new HashMap<>();
        if (ValidateCustomer.validateName(employee.getName()) != null
                || ValidateCustomer.validateIdCard(employee.getIdCard()) != null
                || ValidateCustomer.validatePhoneNumber(employee.getPhone()) != null
                || ValidateCustomer.validateEmail(employee.getEmail()) != null) {
            mapError.put("nameError", ValidateCustomer.validateName(employee.getName()));
            mapError.put("idCardError", ValidateCustomer.validateIdCard(employee.getIdCard()));
            mapError.put("phoneError", ValidateCustomer.validatePhoneNumber(employee.getPhone()));
            mapError.put("emailError", ValidateCustomer.validateEmail(employee.getEmail()));
        } else {
            try {
                repository.addEmployee(employee);
            } catch (SQLException e) {
                String[] arr = e.getMessage().split(" ");
                mapError.put("sqlError", arr[0] + " " + arr[1] + " " + arr[2]);
            }
        }
        return mapError;
    }

    @Override
    public Map<String, String> updateEmployee(Employee employee) {
        Map<String, String> mapError = new HashMap<>();
        if (ValidateCustomer.validateName(employee.getName()) != null
                || ValidateCustomer.validateIdCard(employee.getIdCard()) != null
                || ValidateCustomer.validatePhoneNumber(employee.getPhone()) != null
                || ValidateCustomer.validateEmail(employee.getEmail()) != null) {
            mapError.put("nameError", ValidateCustomer.validateName(employee.getName()));
            mapError.put("idCardError", ValidateCustomer.validateIdCard(employee.getIdCard()));
            mapError.put("phoneError", ValidateCustomer.validatePhoneNumber(employee.getPhone()));
            mapError.put("emailError", ValidateCustomer.validateEmail(employee.getEmail()));
        } else {
            try {
                repository.updateEmployee(employee);
            } catch (SQLException e) {
                String[] arr = e.getMessage().split(" ");
                mapError.put("sqlError", arr[0] + " " + arr[1] + " " + arr[2]);
            }
        }
        return mapError;
    }

    @Override
    public Employee selectById(int id) {
        return repository.selectById(id);
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        return repository.deleteEmployee(id);
    }

    @Override
    public List<Employee> selectByName(String name) {
        return repository.selectByName(name);
    }
}
