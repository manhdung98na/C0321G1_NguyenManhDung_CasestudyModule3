package model.bean;

public class ContractDetail {
    private int idContractDetail;
    private int idContract;
    private int idAttachService;
    private String nameAttachService;
    private int quantity;


    public ContractDetail(int idContractDetail, int idContract, int idAttachService, int quantity) {
        this.idContractDetail = idContractDetail;
        this.idContract = idContract;
        this.idAttachService = idAttachService;
        this.quantity = quantity;
    }


    public ContractDetail(int idContractDetail, int idContract, int idAttachService, String nameAttachService, int quantity) {
        this.idContractDetail = idContractDetail;
        this.idContract = idContract;
        this.idAttachService = idAttachService;
        this.nameAttachService = nameAttachService;
        this.quantity = quantity;
    }

    public int getIdContractDetail() {
        return idContractDetail;
    }

    public void setIdContractDetail(int idContractDetail) {
        this.idContractDetail = idContractDetail;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public int getIdAttachService() {
        return idAttachService;
    }

    public void setIdAttachService(int idAttachService) {
        this.idAttachService = idAttachService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNameAttachService() {
        return nameAttachService;
    }

    public void setNameAttachService(String nameAttachService) {
        this.nameAttachService = nameAttachService;
    }
}
