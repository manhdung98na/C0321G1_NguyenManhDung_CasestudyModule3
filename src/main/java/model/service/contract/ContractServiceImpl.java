package model.service.contract;

import model.bean.Contract;
import model.repository.contract.ContractRepositoryImpl;
import model.service.common.ValidateContract;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContractServiceImpl implements ContractService {
    private ContractRepositoryImpl repository = new ContractRepositoryImpl();

    @Override
    public List<Contract> selectAll() {
        return repository.selectAll();
    }

    @Override
    public Map<String, String> addContract(Contract contract) {
        Map<String, String> mapError = new HashMap<>();
        if (ValidateContract.validateCustomerId(contract.getCustomerId()) != null
                || ValidateContract.validateServiceId(contract.getServiceId()) != null
                || ValidateContract.validateMoney(contract.getDeposit(), contract.getTotalMoney()) != null
                || ValidateContract.validateTime(contract.getStartDate(), contract.getEndDate()) != null) {
            mapError.put("customerIdError", ValidateContract.validateCustomerId(contract.getCustomerId()));
            mapError.put("serviceIdError", ValidateContract.validateServiceId(contract.getServiceId()));
            mapError.put("moneyError", ValidateContract.validateMoney(contract.getDeposit(), contract.getTotalMoney()));
            mapError.put("timeError", ValidateContract.validateTime(contract.getStartDate(), contract.getEndDate()));
        } else {
            try {
                repository.addContract(contract);
            } catch (SQLException e) {
                mapError.put("sqlError", e.getMessage());
            }
        }
        return mapError;
    }
}
