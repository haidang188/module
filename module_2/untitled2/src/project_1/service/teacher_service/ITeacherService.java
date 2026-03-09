package project_1.service.teacher_service;

import project_1.model.Teacher;

import java.util.List;

public interface ITeacherService {
    void save(Teacher teacher);
    void update(Teacher teacher);
    void delete(int id);
    List<Teacher> findAll();
    Teacher findById(int id);
    List<Teacher> findByName(String name);
}
