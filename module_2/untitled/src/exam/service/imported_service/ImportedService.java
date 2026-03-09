package exam.service.imported_service;

import exam.io_stream.ImportedIOStream;
import exam.model.Imported;
import exam.repository.imported_repository.IImportedRepository;
import exam.repository.imported_repository.ImportedRepository;

import java.util.ArrayList;
import java.util.List;

public class ImportedService implements IImportedService {
    private IImportedRepository iImportedRepository = new ImportedRepository();
    @Override
    public void save(Imported imported) {
    iImportedRepository.save(imported);
    }

    @Override
    public void delete(int id) {
    iImportedRepository.delete(id);
    }

    @Override
    public Imported findById(int id) {
        return iImportedRepository.findById(id);
    }

    @Override
    public List<Imported> findAll() {
        return iImportedRepository.findAll();
    }

    @Override
    public List<Imported> findByName(String name) {
        List<Imported> result = new ArrayList<>();
        String keyword = name.toLowerCase();
        for (Imported imported : ImportedIOStream.readImportedFromFile()) {
            if (imported.getName().toLowerCase().contains(keyword)) {
                result.add(imported);
            }
        }
        return result;
    }
}
