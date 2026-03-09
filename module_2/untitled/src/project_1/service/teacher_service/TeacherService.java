package project_1.service.teacher_service;

import project_1.model.Teacher;
import project_1.repository.teacher_repository.ITeacherRepository;
import project_1.repository.teacher_repository.TeacherRepository;

import java.util.List;

public class TeacherService implements ITeacherService {
    private ITeacherRepository iTeacherRepository = new TeacherRepository();

    @Override
    public void save(Teacher teacher) {
        iTeacherRepository.save(teacher);

    }

    @Override
    public void update(Teacher teacher) {
        iTeacherRepository.update(teacher);

    }

    @Override
    public void delete(int id) {
        iTeacherRepository.delete(id);
    }

    @Override
    public Teacher findById(int id) {
        return iTeacherRepository.findById(id);

    }

    @Override
    public List<Teacher> findAll() {
        return iTeacherRepository.findAll();
    }

    @Override
    public List<Teacher> searchByName(String name) {
        return iTeacherRepository.searchByName(name);
    }
}
