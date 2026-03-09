package exam.service.official_service;

import exam.model.Official;
import exam.repository.offcial_repository.IOfficialRepository;
import exam.repository.offcial_repository.OfficialRepository;

import java.util.List;

public class OfficialService implements IOfficialService {
    private IOfficialRepository iOfficialRepository = new OfficialRepository();


    @Override
    public void save(Official official) {
    iOfficialRepository.save(official);
    }

    @Override
    public void delete(int id) {
iOfficialRepository.delete(id);
    }

    @Override
    public Official findById(int id) {
        return iOfficialRepository.findById(id);
    }

    @Override
    public List<Official> findAll() {
        return iOfficialRepository.findAll();
    }
    public List<Official> findByName(String name) {
        return iOfficialRepository.findByName(name);
    }
}
