package model.bean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CustomerUsingService {
    private String idCustomer;
    private String nameCustomer;
    private int idContract;
    private Date startDate;
    private Date endDate;
    private String idService;
    private String nameService;
    private List<String> attactServiceName;

    public CustomerUsingService(String idCustomer, String nameCustomer, int idContract, Date startDate, Date endDate, String idService, String nameService, String attactServiceName) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.idContract = idContract;
        this.startDate = startDate;
        this.endDate = endDate;
        this.idService = idService;
        this.nameService = nameService;
        this.attactServiceName = new ArrayList<>();
        this.attactServiceName.add(attactServiceName);
    }

    public CustomerUsingService(String idCustomer, String nameCustomer, int idContract, Date startDate, Date endDate, String nameService, String attactServiceName) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.idContract = idContract;
        this.startDate = startDate;
        this.endDate = endDate;
        this.nameService = nameService;
        this.attactServiceName = new ArrayList<>();
        this.attactServiceName.add(attactServiceName);
    }

    public void addAttachServiceName(String nameService) {
        this.attactServiceName.add(nameService);
    }

    public String getStringAttachService() {
        if (this.attactServiceName.get(0) == null) return "No attach service";
        StringBuilder result = new StringBuilder();
        for (String o : this.attactServiceName) {
            result.append(o).append(", ");
        }
        String resultString = String.valueOf(result).trim();
        return resultString.substring(0, resultString.length() - 1);
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public List<String> getAttactServiceName() {
        return attactServiceName;
    }

    public void setAttactServiceName(List<String> attactServiceName) {
        this.attactServiceName = attactServiceName;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }
}
