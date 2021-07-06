package model.service.service;

import model.bean.Service;
import model.repository.service.ServiceRepositoryImpl;

import java.util.List;

public class ResortServiceImpl implements ResortService{
    private ServiceRepositoryImpl repository = new ServiceRepositoryImpl();

    @Override
    public List<Service> selectAll() {
        return repository.selectAll();
    }

    @Override
    public boolean addService(Service service) {
        return repository.addService(service);
    }
}
