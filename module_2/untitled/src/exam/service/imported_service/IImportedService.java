package exam.service.imported_service;

import exam.model.Imported;

import java.util.List;

public interface IImportedService {
    void save(Imported imported);
    void delete(int id);
    Imported findById(int id);
    List<Imported> findAll();
    List<Imported> findByName(String name);
}
