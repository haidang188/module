package exam.repository.offcial_repository;

import exam.model.Official;

import java.util.List;

public interface IOfficialRepository {
    void save(Official official);
    void delete(int id);
    Official findById(int id);
    List<Official> findAll();
    List<Official> findByName(String name);
}
