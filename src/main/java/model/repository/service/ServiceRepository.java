package model.repository.service;

import model.bean.Service;

import java.util.List;

public interface ServiceRepository {
    public List<Service> selectAll();
    public boolean addService(Service service);
}
