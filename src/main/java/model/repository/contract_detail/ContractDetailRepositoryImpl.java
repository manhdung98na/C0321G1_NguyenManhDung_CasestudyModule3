package model.repository.contract_detail;

import model.bean.ContractDetail;
import model.repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepositoryImpl implements ContractDetailRepository {
    private static final String SELECT_ALL_CONTRACT_DETAIL =
            "select contract_detail_id, c.contract_id, `as`.attach_service_id, `as`.attach_service_name,quantity " +
                    "from contract_detail cd join contract c on cd.contract_id = c.contract_id" +
                    " join attach_service `as` on cd.attach_service_id = `as`.attach_service_id";
    private static final String INSERT_CONTRACT_DETAIL_SQL = "INSERT INTO contract_detail VALUES (?, ?, ?, ?);";

    @Override
    public List<ContractDetail> selectAll() {
        List<ContractDetail> result = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_CONTRACT_DETAIL);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("contract_detail_id");
                    int contract_id = resultSet.getInt("contract_id");
                    int service_id = resultSet.getInt("attach_service_id");
                    String service_name = resultSet.getString("attach_service_name");
                    int quantity = resultSet.getInt("quantity");
                    result.add(new ContractDetail(id, contract_id, service_id, service_name, quantity));
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
    public boolean addContractDetail(ContractDetail contractDetail) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_CONTRACT_DETAIL_SQL);
                statement.setInt(1, contractDetail.getIdContractDetail());
                statement.setInt(2, contractDetail.getIdContract());
                statement.setInt(3, contractDetail.getIdAttachService());
                statement.setInt(4, contractDetail.getQuantity());
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
