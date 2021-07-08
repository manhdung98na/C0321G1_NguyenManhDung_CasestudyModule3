package model.service.contract_detail;

import model.bean.ContractDetail;

import java.util.List;
import java.util.Map;

public interface ContractDetailService {
    List<ContractDetail> selectAll();

    Map<String,String> addContractDetail(ContractDetail contractDetail);
}
