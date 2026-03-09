package exam.repository.imported_repository;

import exam.io_stream.ImportedIOStream;
import exam.model.Imported;

import java.util.ArrayList;
import java.util.List;

public class ImportedRepository implements IImportedRepository {
    private static int lastId;

    static {
        List<Imported> importeds = ImportedIOStream.readImportedFromFile();
        if (!importeds.isEmpty()) {
            lastId = importeds.get(importeds.size() - 1).getId();
        } else {
            lastId = 0;
        }
    }
    @Override
    public void save(Imported imported) {
        imported.setId(++lastId);
        ImportedIOStream.writeImportedInfoFile(imported);
    }

    @Override
    public void delete(int id) {
        List<Imported> importedsList = ImportedIOStream.readImportedFromFile();


        for (int i = 0; i < importedsList.size(); i++) {
            Imported imported = importedsList.get(i);
            if (imported != null && imported.getId() == id) {
                importedsList.remove(i);
                break;
            }
        }
        ImportedIOStream.writeListImportedInfoFile(importedsList);
    }

    @Override
    public Imported findById(int id) {
        for (Imported imported : ImportedIOStream.readImportedFromFile()) {
            if (imported.getId() == id) {
                return imported;
            }
        }
        return null;
    }

    @Override
    public List<Imported> findAll() {
        return ImportedIOStream.readImportedFromFile();
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



