package exam.controller;

import exam.model.Imported;
import exam.service.imported_service.IImportedService;
import exam.service.imported_service.ImportedService;

import java.util.List;

public class ImportedController {
    private IImportedService iImportedService = new ImportedService();

    public void findAll() {
        for (Imported imported : iImportedService.findAll()) {
            System.out.println(imported);
        }
    }
    public void saveImported(Imported imported) {
        iImportedService.save(imported);
    }
    public void deleteImported(Imported imported) {
        iImportedService.delete(imported.getId());
    }
    public Imported findById(int id) {
        return iImportedService.findById(id);
    }

    public List<Imported> findByName(String name) {
        return iImportedService.findByName(name);
    }
}
