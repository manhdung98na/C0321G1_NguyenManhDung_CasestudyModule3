package model.repository.customer;

import model.bean.Customer;
import model.repository.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private static final String SELECT_ALL_CUSTOMER = "select * from customer join customer_type ct on customer.customer_type_id = ct.customer_type_id";
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set " +
            "customer_type_id = ?, customer_name = ?, customer_birthday = ?, customer_gender = ?," +
            " customer_id_card= ?, customer_phone = ?, customer_email = ?,customer_address = ?  where customer_id = ?;";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id = ?";
    private static final String SELECT_CUSTOMER_BY_IDCARD = "select * from customer where customer_id_card = ?";
    private static final String SELECT_CUSTOMER_BY_PHONE = "select * from customer where customer_phone = ?";
    private static final String SELECT_CUSTOMER_BY_EMAIL = "select * from customer where customer_email = ?";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?;";

    private static final String SELECT_CUSTOMER_BY_NAME = "select * from customer join customer_type ct on customer.customer_type_id = ct.customer_type_id where customer_name like ? order by customer_name";

    @Override
    public List<Customer> selectAll() {
        List<Customer> result = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String customerId = resultSet.getString("customer_id");
                    String customerTypeName = resultSet.getString("customer_type_name");
                    String customerName = resultSet.getString("customer_name");
                    Date customerBirthday = resultSet.getDate("customer_birthday");
                    String customerGender = resultSet.getString("customer_gender");
                    String customerIdCard = resultSet.getString("customer_id_card");
                    String customerPhone = resultSet.getString("customer_phone");
                    String customerEmail = resultSet.getString("customer_email");
                    String customerAddress = resultSet.getString("customer_address");
                    result.add(new Customer(customerId, customerTypeName, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress));
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
    public Customer selectById(String id) {
        Customer customer = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
                statement.setString(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String customerId = resultSet.getString("customer_id");
                    int customerType = resultSet.getInt("customer_type_id");
                    String customerName = resultSet.getString("customer_name");
                    Date customerBirthday = resultSet.getDate("customer_birthday");
                    String customerGender = resultSet.getString("customer_gender");
                    String customerIdCard = resultSet.getString("customer_id_card");
                    String customerPhone = resultSet.getString("customer_phone");
                    String customerEmail = resultSet.getString("customer_email");
                    String customerAddress = resultSet.getString("customer_address");
                    customer = new Customer(customerId, customerType, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
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
        return customer;
    }

    @Override
    public Customer selectByIdCard(String idCard) {
        Customer customer = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_CUSTOMER_BY_IDCARD);
                statement.setString(1, idCard);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String customerId = resultSet.getString("customer_id");
                    int customerType = resultSet.getInt("customer_type_id");
                    String customerName = resultSet.getString("customer_name");
                    Date customerBirthday = resultSet.getDate("customer_birthday");
                    String customerGender = resultSet.getString("customer_gender");
                    String customerIdCard = resultSet.getString("customer_id_card");
                    String customerPhone = resultSet.getString("customer_phone");
                    String customerEmail = resultSet.getString("customer_email");
                    String customerAddress = resultSet.getString("customer_address");
                    customer = new Customer(customerId, customerType, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
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
        return customer;
    }

    @Override
    public Customer selectByPhone(String phone) {
        Customer customer = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_CUSTOMER_BY_PHONE);
                statement.setString(1, phone);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String customerId = resultSet.getString("customer_id");
                    int customerType = resultSet.getInt("customer_type_id");
                    String customerName = resultSet.getString("customer_name");
                    Date customerBirthday = resultSet.getDate("customer_birthday");
                    String customerGender = resultSet.getString("customer_gender");
                    String customerIdCard = resultSet.getString("customer_id_card");
                    String customerPhone = resultSet.getString("customer_phone");
                    String customerEmail = resultSet.getString("customer_email");
                    String customerAddress = resultSet.getString("customer_address");
                    customer = new Customer(customerId, customerType, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
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
        return customer;
    }

    @Override
    public Customer selectByEmail(String email) {
        Customer customer = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_CUSTOMER_BY_EMAIL);
                statement.setString(1, email);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String customerId = resultSet.getString("customer_id");
                    int customerType = resultSet.getInt("customer_type_id");
                    String customerName = resultSet.getString("customer_name");
                    Date customerBirthday = resultSet.getDate("customer_birthday");
                    String customerGender = resultSet.getString("customer_gender");
                    String customerIdCard = resultSet.getString("customer_id_card");
                    String customerPhone = resultSet.getString("customer_phone");
                    String customerEmail = resultSet.getString("customer_email");
                    String customerAddress = resultSet.getString("customer_address");
                    customer = new Customer(customerId, customerType, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
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
        return customer;
    }

    @Override
    public List<Customer> selectByName(String name) throws SQLException {
        List<Customer> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_CUSTOMER_BY_NAME);
                String countryCondition = "%" + name + "%";
                statement.setString(1, countryCondition);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String customerId = resultSet.getString("customer_id");
                    int customerType = resultSet.getInt("customer_type_id");
                    String customerTypeName = resultSet.getString("customer_type_name");
                    String customerName = resultSet.getString("customer_name");
                    Date customerBirthday = resultSet.getDate("customer_birthday");
                    String customerGender = resultSet.getString("customer_gender");
                    String customerIdCard = resultSet.getString("customer_id_card");
                    String customerPhone = resultSet.getString("customer_phone");
                    String customerEmail = resultSet.getString("customer_email");
                    String customerAddress = resultSet.getString("customer_address");
                    list.add(new Customer(customerId, customerType, customerTypeName, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                throw new SQLException(throwables);
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return list;
    }

    @Override
    public boolean isIdExist(String id) {
        return selectById(id) != null;
    }

    @Override
    public boolean isIdCardExist(String idCard) {
        return selectByIdCard(idCard) != null;
    }

    @Override
    public boolean isPhoneExist(String phone) {
        return selectByPhone(phone) != null;
    }

    @Override
    public boolean isEmailExist(String email) {
        return selectByEmail(email) != null;
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);
                statement.setString(1, id);
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                throw new SQLException(throwables);
            } finally {
                statement.close();
                DBConnection.close();
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean addCustomer(Customer customer) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_CUSTOMER_SQL);
                statement.setString(1, customer.getCustomerId());
                statement.setInt(2, customer.getCustomerType());
                statement.setString(3, customer.getCustomerName());
                statement.setDate(4, customer.getCustomerBirthday());
                statement.setString(5, customer.getCustomerGender());
                statement.setString(6, customer.getCustomerIdCard());
                statement.setString(7, customer.getCustomerPhone());
                statement.setString(8, customer.getCustomerEmail());
                statement.setString(9, customer.getCustomerAddress());
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

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);
            statement.setInt(1, customer.getCustomerType());
            statement.setString(2, customer.getCustomerName());
            statement.setDate(3, customer.getCustomerBirthday());
            statement.setString(4, customer.getCustomerGender());
            statement.setString(5, customer.getCustomerIdCard());
            statement.setString(6, customer.getCustomerPhone());
            statement.setString(7, customer.getCustomerEmail());
            statement.setString(8, customer.getCustomerAddress());
            statement.setString(9, customer.getCustomerId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new SQLException(throwables);
        } finally {
            statement.close();
            connection.close();
        }
        return rowUpdated;
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
