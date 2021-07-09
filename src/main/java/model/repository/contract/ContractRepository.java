package model.repository.contract;

import model.bean.Contract;

import java.sql.SQLException;
import java.util.List;

public interface ContractRepository {
    public List<Contract> selectAll();

    public boolean addContract(Contract contract) throws SQLException;

//    public boolean updateContract(Contract contract) throws SQLException;

    public Contract selectById(int id);

//    public boolean deleteContract(String id) throws SQLException;

//    public List<Contract> selectByName(String name) throws SQLException;
}
