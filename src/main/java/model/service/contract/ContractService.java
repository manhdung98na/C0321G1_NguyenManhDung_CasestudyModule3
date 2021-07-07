package model.service.contract;

import model.bean.Contract;

import java.util.List;
import java.util.Map;

public interface ContractService {
    public List<Contract> selectAll();

    public Map<String, String> addContract(Contract contract);

//    public Map<String, String> updateContract(Contract contract);

//    public Contract selectById(String id);

//    public boolean deleteContract(String id) throws SQLException;

//    public List<Contract> selectByName(String name) throws SQLException;
}
