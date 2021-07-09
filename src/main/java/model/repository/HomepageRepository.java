package model.repository;

import model.bean.CustomerUsingService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HomepageRepository {
    private static final String SELECT = "select " +
            "c.customer_id, customer_name, c2.contract_id, contract_start_date, contract_end_date, s.service_id, service_name, attach_service_name " +
            "from customer c " +
            "join contract c2 on c.customer_id = c2.customer_id " +
            "join service s on c2.service_id = s.service_id " +
            "left join contract_detail cd on c2.contract_id = cd.contract_id " +
            "left join attach_service `as` on cd.attach_service_id = `as`.attach_service_id";

    public static List<CustomerUsingService> selectCustomerUsingService() {
        List<CustomerUsingService> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT);
                rs = statement.executeQuery();
                while (rs.next()) {
                    int idContract = rs.getInt("contract_id");
                    if (list.isEmpty()) {
                        String idCustomer = rs.getString("customer_id");
                        String nameCustomer = rs.getString("customer_name");
                        Date startDate = rs.getDate("contract_start_date");
                        Date endDate = rs.getDate("contract_end_date");
                        String idService = rs.getString("service_id");
                        String nameService = rs.getString("service_name");
                        String attactServiceName = rs.getString("attach_service_name");
                        CustomerUsingService customer = new CustomerUsingService(idCustomer, nameCustomer, idContract, startDate, endDate, idService, nameService, attactServiceName);
                        list.add(customer);
                    } else {
                        boolean isExisted = false;
                        for (int i = 0; i < list.size(); i++) {
                            if (idContract == list.get(i).getIdContract()) {
                                String attactServiceName = rs.getString("attach_service_name");
                                list.get(i).addAttachServiceName(attactServiceName);
                                isExisted = true;
                                break;
                            }
                        }
                        if (!isExisted) {
                            String idCustomer = rs.getString("customer_id");
                            String nameCustomer = rs.getString("customer_name");
                            Date startDate = rs.getDate("contract_start_date");
                            Date endDate = rs.getDate("contract_end_date");
                            String idService = rs.getString("service_id");
                            String nameService = rs.getString("service_name");
                            String attactServiceName = rs.getString("attach_service_name");
                            CustomerUsingService customer = new CustomerUsingService(idCustomer, nameCustomer, idContract, startDate, endDate, idService, nameService, attactServiceName);
                            list.add(customer);
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(list);
        return list;
    }
}
