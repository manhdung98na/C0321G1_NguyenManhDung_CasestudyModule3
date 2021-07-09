package model.service.service;

import model.bean.Service;

import java.util.List;
import java.util.Map;

public interface ResortService {
    public List<Service> selectAll();

    public Map<String, String> addService(Service service);

    public Service selectById(String id);
}
