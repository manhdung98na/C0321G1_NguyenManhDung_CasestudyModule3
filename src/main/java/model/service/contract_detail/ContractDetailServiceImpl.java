package model.service.contract_detail;

import model.bean.ContractDetail;
import model.repository.contract_detail.ContractDetailRepositoryImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContractDetailServiceImpl implements ContractDetailService{
    private ContractDetailRepositoryImpl repository = new ContractDetailRepositoryImpl();
    @Override
    public List<ContractDetail> selectAll() {
        return repository.selectAll();
    }

    @Override
    public Map<String, String> addContractDetail(ContractDetail contractDetail) {
        Map<String,String> map = new HashMap<>();
        try {
            repository.addContractDetail(contractDetail);
        } catch (SQLException e) {
            e.printStackTrace();
            map.put("sqlError", e.getMessage());
        }
        return map;
    }
}
