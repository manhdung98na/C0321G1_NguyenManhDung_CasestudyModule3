package model.service.service;

import model.bean.Service;

import java.util.List;

public interface ResortService {
    public List<Service> selectAll();
    public boolean addService(Service service);
}
