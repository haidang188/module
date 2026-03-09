package exam.controller;

import exam.model.Official;
import exam.service.official_service.IOfficialService;
import exam.service.official_service.OfficialService;

import java.util.List;

public class OfficialController {
    private IOfficialService iOfficialService = new OfficialService();

    public void findAll() {
        for (Official official : iOfficialService.findAll()) {
            System.out.println(official);
        }
    }

    public void saveOfficial(Official official) {
        iOfficialService.save(official);
    }

    public void deleteOfficial(Official official) {
        iOfficialService.delete(official.getId());
    }

    public Official findById(int id) {
        return iOfficialService.findById(id);
    }

    public List<Official> findByName(String name) {
        return iOfficialService.findByName(name);
    }
}
