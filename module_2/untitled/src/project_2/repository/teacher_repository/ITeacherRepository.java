package project_2.repository.teacher_repository;

import project_2.model.Teacher;

import java.util.List;

public interface ITeacherRepository {
    void save(Teacher teacher);
    void update(Teacher teacher);
    void delete(int id);
    Teacher findById(int id);
    List<Teacher> findAll();
    List<Teacher> searchByName(String name);
}
