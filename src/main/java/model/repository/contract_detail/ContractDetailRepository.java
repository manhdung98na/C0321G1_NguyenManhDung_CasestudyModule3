package model.repository.contract_detail;

import model.bean.ContractDetail;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ContractDetailRepository {
    List<ContractDetail> selectAll();

    boolean addContractDetail(ContractDetail contractDetail) throws SQLException;
}
