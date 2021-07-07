package model.repository.employee;

import model.bean.Customer;
import model.bean.Employee;
import model.repository.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static final String SELECT_ALL_EMPLOYEE = "select " +
            "employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, e.position_id, p.position_name, e.education_degree_id, ed.education_degree_name, e.division_id, d.division_name" +
            " from employee e " +
            "join position p on e.position_id = p.position_id " +
            "join education_degree ed on e.education_degree_id = ed.education_degree_id " +
            "join division d on e.division_id = d.division_id";
    private static final String SELECT_EMPLOYEE_BY_ID = "select" +
            " employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, e.position_id, p.position_name, e.education_degree_id, ed.education_degree_name, e.division_id, d.division_name" +
            " from employee e " +
            " join position p on e.position_id = p.position_id " +
            " join education_degree ed on e.education_degree_id = ed.education_degree_id " +
            " join division d on e.division_id = d.division_id where e.employee_id = ?";

    private static final String SELECT_EMPLOYEE_BY_NAME = "select" +
            " employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, e.position_id, p.position_name, e.education_degree_id, ed.education_degree_name, e.division_id, d.division_name" +
            " from employee e " +
            " join position p on e.position_id = p.position_id " +
            " join education_degree ed on e.education_degree_id = ed.education_degree_id " +
            " join division d on e.division_id = d.division_id where employee_name like ?";

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee" +
            "(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id)" +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String UPDATE_EMPLOYEE_SQL = "update employee set " +
            "employee_id = ?, employee_name = ?, employee_birthday = ?, employee_id_card = ?, employee_salary = ?, employee_phone = ?, employee_email = ?, employee_address = ?, position_id = ?, education_degree_id = ?, division_id = ? where employee_id = ?;";

    private static final String DELETE_EMPLOYEE_SQL = "delete from employee where employee_id = ?;";

    @Override
    public List<Employee> selectAll() {
        List<Employee> result = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("employee_id");
                    String name = resultSet.getString("employee_name");
                    Date birthday = resultSet.getDate("employee_birthday");
                    String idCard = resultSet.getString("employee_id_card");
                    double salary = Double.parseDouble(resultSet.getString("employee_salary"));
                    String phone = resultSet.getString("employee_phone");
                    String email = resultSet.getString("employee_email");
                    String address = resultSet.getString("employee_address");
                    int positionId = Integer.parseInt(resultSet.getString("position_id"));
                    String positionName = resultSet.getString("position_name");
                    int educationId = Integer.parseInt(resultSet.getString("education_degree_id"));
                    String educationName = resultSet.getString("education_degree_name");
                    int divisionId = Integer.parseInt(resultSet.getString("division_id"));
                    String divisionName = resultSet.getString("division_name");
                    result.add(new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId, positionName, educationId, educationName, divisionId, divisionName));
                }
            } catch (SQLException e) {
                printSQLException(e);
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return result;
    }

    @Override
    public Employee selectById(int id) {
        Employee result = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int idEmployee = resultSet.getInt("employee_id");
                    String name = resultSet.getString("employee_name");
                    Date birthday = resultSet.getDate("employee_birthday");
                    String idCard = resultSet.getString("employee_id_card");
                    double salary = Double.parseDouble(resultSet.getString("employee_salary"));
                    String phone = resultSet.getString("employee_phone");
                    String email = resultSet.getString("employee_email");
                    String address = resultSet.getString("employee_address");
                    int positionId = Integer.parseInt(resultSet.getString("position_id"));
                    String positionName = resultSet.getString("position_name");
                    int educationId = Integer.parseInt(resultSet.getString("education_degree_id"));
                    String educationName = resultSet.getString("education_degree_name");
                    int divisionId = Integer.parseInt(resultSet.getString("division_id"));
                    String divisionName = resultSet.getString("division_name");
                    result = new Employee(idEmployee, name, birthday, idCard, salary, phone, email, address, positionId, positionName, educationId, educationName, divisionId, divisionName);
                }
            } catch (SQLException e) {
                printSQLException(e);
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return result;
    }

    @Override
    public List<Employee> selectByName(String name) {
        List<Employee> result = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_EMPLOYEE_BY_NAME);
                statement.setString(1, "%" + name + "%");
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int idEmployee = resultSet.getInt("employee_id");
                    String nameEmployee = resultSet.getString("employee_name");
                    Date birthdayEmployee = resultSet.getDate("employee_birthday");
                    String idCardEmployee = resultSet.getString("employee_id_card");
                    double salaryEmployee = Double.parseDouble(resultSet.getString("employee_salary"));
                    String phoneEmployee = resultSet.getString("employee_phone");
                    String emailEmployee = resultSet.getString("employee_email");
                    String addressEmployee = resultSet.getString("employee_address");
                    int positionId = Integer.parseInt(resultSet.getString("position_id"));
                    String positionName = resultSet.getString("position_name");
                    int educationId = Integer.parseInt(resultSet.getString("education_degree_id"));
                    String educationName = resultSet.getString("education_degree_name");
                    int divisionId = Integer.parseInt(resultSet.getString("division_id"));
                    String divisionName = resultSet.getString("division_name");
                    result.add(new Employee(idEmployee, nameEmployee, birthdayEmployee, idCardEmployee, salaryEmployee, phoneEmployee, emailEmployee, addressEmployee, positionId, positionName, educationId, educationName, divisionId, divisionName));
                }
            } catch (SQLException e) {
                printSQLException(e);
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return result;
    }

    @Override
    public boolean addEmployee(Employee employee) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_EMPLOYEE_SQL);
                statement.setInt(1, employee.getId());
                statement.setString(2, employee.getName());
                statement.setDate(3, employee.getBirthday());
                statement.setString(4, employee.getIdCard());
                statement.setDouble(5, employee.getSalary());
                statement.setString(6, employee.getPhone());
                statement.setString(7, employee.getEmail());
                statement.setString(8, employee.getAddress());
                statement.setInt(9, employee.getPositionId());
                statement.setInt(10, employee.getEducationDegreeId());
                statement.setInt(11, employee.getDivisionId());
                statement.executeUpdate();
            } catch (SQLException e) {
                printSQLException(e);
                throw new SQLException(e.getMessage());
            } finally {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return true;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getName());
            statement.setDate(3, employee.getBirthday());
            statement.setString(4, employee.getIdCard());
            statement.setDouble(5, employee.getSalary());
            statement.setString(6, employee.getPhone());
            statement.setString(7, employee.getEmail());
            statement.setString(8, employee.getAddress());
            statement.setInt(9, employee.getPositionId());
            statement.setInt(10, employee.getEducationDegreeId());
            statement.setInt(11, employee.getDivisionId());
            statement.setInt(12, employee.getId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new SQLException(throwables.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            connection.close();
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                throw new SQLException(throwables.getMessage());
            } finally {
                if (statement != null) {
                    statement.close();
                }
                DBConnection.close();
            }
            return true;
        }
        return false;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
