package exam.repository.offcial_repository;

import exam.io_stream.OfficialIOStream;
import exam.model.Official;

import java.util.ArrayList;
import java.util.List;

public class OfficialRepository implements IOfficialRepository {
    private static int lastId;

    static {
        List<Official> officials = OfficialIOStream.readOfficialFromFile();
        if (!officials.isEmpty()) {
            lastId = officials.get(officials.size() - 1).getId();
        } else {
            lastId = 0;
        }
    }

    @Override
    public void save(Official official) {
        official.setId(++lastId);
        OfficialIOStream.writeOfficicalInfoFile(official);

    }

    @Override
    public void delete(int id) {
        List<Official> officialsList = OfficialIOStream.readOfficialFromFile();
        for (int i = 0; i < officialsList.size(); i++) {
            Official official = officialsList.get(i);
            if (official != null && official.getId() == id) {
                officialsList.remove(i);
                break;
            }
        }
        OfficialIOStream.writeListOfficialInfoFile(officialsList);
    }

    @Override
    public Official findById(int id) {
        for (Official official : OfficialIOStream.readOfficialFromFile()) {
            if (official.getId() == id) {
                return official;
            }
        }
        return null;
    }

    @Override
    public List<Official> findAll() {
        return OfficialIOStream.readOfficialFromFile();
    }

    @Override
    public List<Official> findByName(String name) {
        List<Official> result = new ArrayList<>();
        String keyword = name.toLowerCase();
        for (Official official : OfficialIOStream.readOfficialFromFile()) {
            if (official.getName().toLowerCase().contains(keyword)) {
                result.add(official);
            }
        }
        return result;
    }
}
