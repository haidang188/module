package project_1.repository.teacher_repository;

import project_1.model.Teacher;

import java.util.List;

public interface ITeacherRepository {
    void save(Teacher teacher);
    void update(Teacher teacher);
    void delete(int id);
    List<Teacher> findAll();
    Teacher findById(int id);
    List<Teacher> findByName(String name);
}
