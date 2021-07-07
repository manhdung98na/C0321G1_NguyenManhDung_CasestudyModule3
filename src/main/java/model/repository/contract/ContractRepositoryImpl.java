package model.repository.contract;

import model.bean.Contract;
import model.repository.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImpl implements ContractRepository {
    private static final String SELECT_ALL_CONTRACT = "select " +
            "contract_id, contract_start_date, contract_end_date, contract_deposit, contract_total_money, c.employee_id, e.employee_name, c.customer_id, c2.customer_name, c.service_id, s.service_name" +
            " from contract c join employee e on c.employee_id = e.employee_id" +
            " join customer c2 on c.customer_id = c2.customer_id" +
            " join service s on c.service_id = s.service_id";
    private static final String INSERT_CONTRACT_SQL = "INSERT INTO contract VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

    @Override
    public List<Contract> selectAll() {
        List<Contract> result = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_CONTRACT);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("contract_id");
                    Date startDate = resultSet.getDate("contract_start_date");
                    Date endDate = resultSet.getDate("contract_end_date");
                    double deposit = resultSet.getDouble("contract_deposit");
                    double totalMoney = resultSet.getDouble("contract_total_money");
                    int employeeId = resultSet.getInt("employee_id");
                    String employeeName = resultSet.getString("employee_name");
                    String custommerId = resultSet.getString("customer_id");
                    String customerName = resultSet.getString("customer_name");
                    String serviceId = resultSet.getString("service_id");
                    String serviceName = resultSet.getString("service_name");
                    result.add(new Contract(id, startDate, endDate, deposit, totalMoney, employeeId, employeeName, custommerId, customerName, serviceId, serviceName));
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
    public boolean addContract(Contract contract) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_CONTRACT_SQL);
                statement.setInt(1, contract.getId());
                statement.setDate(2, contract.getStartDate());
                statement.setDate(3, contract.getEndDate());
                statement.setDouble(4, contract.getDeposit());
                statement.setDouble(5, contract.getTotalMoney());
                statement.setInt(6, contract.getEmployeeId());
                statement.setString(7, contract.getCustomerId());
                statement.setString(8, contract.getServiceId());
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
