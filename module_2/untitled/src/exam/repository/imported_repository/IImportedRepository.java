package exam.repository.imported_repository;

import exam.model.Imported;

import java.util.List;

public interface IImportedRepository {
    void save(Imported imported);
    void delete(int id);
    Imported findById(int id);
    List<Imported> findAll();
    List<Imported> findByName(String keyword);
}
