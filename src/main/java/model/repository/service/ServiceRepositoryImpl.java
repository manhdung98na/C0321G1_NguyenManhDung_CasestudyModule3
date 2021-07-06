package model.repository.service;

import model.bean.Service;
import model.repository.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository {
    private static final String SELECT_ALL_SERVICE =
            "select service_id, service_name, service_area, service_cost, service_max_people, rt.rent_type_name, st.service_type_name, standard_room, description_other_convenience, pool_area, number_of_floors " +
                    "from service s join service_type st on s.service_type_id = st.service_type_id " +
                    "join rent_type rt on s.rent_type_id = rt.rent_type_id";
    private static final String INSERT_SERVICE_SQL = "INSERT INTO service VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
//    private static final String UPDATE_CUSTOMER_SQL = "update customer set " +
//            "customer_type_id = ?, customer_name = ?, customer_birthday = ?, customer_gender = ?," +
//            " customer_id_card= ?, customer_phone = ?, customer_email = ?,customer_address = ?  where customer_id = ?;";
//    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id = ?";
//    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?;";
//    private static final String SELECT_CUSTOMER_BY_NAME = "select * from customer where customer_name like ? order by service_name";

    @Override
    public List<Service> selectAll() {
        List<Service> result = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_SERVICE);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString("service_id");
                    String name = resultSet.getString("service_name");
                    int area = resultSet.getInt("service_area");
                    double cost = resultSet.getDouble("service_cost");
                    int maxPeople = resultSet.getInt("service_max_people");
                    String rentType = resultSet.getString("rent_type_name");
                    String serviceType = resultSet.getString("service_type_name");
                    String standardRoom = resultSet.getString("standard_room");
                    String descriptionConvenience = resultSet.getString("description_other_convenience");
                    double poolArea = resultSet.getDouble("pool_area");
                    int floor = resultSet.getInt("number_of_floors");
                    result.add(new Service(id, name, area, cost, maxPeople, rentType, serviceType, standardRoom, descriptionConvenience, poolArea, floor));
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
    public boolean addService(Service service) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_SERVICE_SQL);
                statement.setString(1, service.getId());
                statement.setString(2, service.getName());
                statement.setInt(3, service.getArea());
                statement.setDouble(4, service.getCost());
                statement.setInt(5, service.getMaxPeople());
                statement.setInt(6, service.getRentTypeId());
                statement.setInt(7, service.getServiceTypeId());
                statement.setString(8, service.getStandardRoom());
                statement.setString(9, service.getDescriptionConvenience());
                statement.setDouble(10, service.getPoolArea());
                statement.setInt(11, service.getFloor());
                statement.executeUpdate();
            } catch (SQLException e) {
                printSQLException(e);
                throw new SQLException(e);
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
