package model.service.service;

import common.ValidateService;
import model.bean.Service;
import model.repository.service.ServiceRepositoryImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResortServiceImpl implements ResortService {
    private ServiceRepositoryImpl repository = new ServiceRepositoryImpl();

    @Override
    public List<Service> selectAll() {
        return repository.selectAll();
    }

    @Override
    public Map<String, String> addService(Service service) {
        Map<String, String> mapError = new HashMap<>();
        if (ValidateService.validateName(service.getName()) != null
                || ValidateService.validateID(service.getId()) != null) {
            mapError.put("nameError", ValidateService.validateName(service.getName()));
            mapError.put("idError", ValidateService.validateID(service.getId()));
        } else {
            try {
                repository.addService(service);
            } catch (SQLException e) {
                String[] arr = e.getMessage().split(" ", 5);
                mapError.put("sqlError", arr[1] + " " + arr[2] + " " + arr[3]);
            }
        }
        return mapError;
    }
}
