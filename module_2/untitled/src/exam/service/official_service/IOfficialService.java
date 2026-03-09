package exam.service.official_service;

import exam.model.Official;

import java.util.List;

public interface IOfficialService {
    void save(Official official);
    void delete(int id);
    Official findById(int id);
    List<Official> findAll();
    List<Official> findByName(String name);
}
