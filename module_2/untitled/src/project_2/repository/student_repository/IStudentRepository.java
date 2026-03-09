package project_2.repository.student_repository;

import project_2.model.Student;

import java.util.List;

public interface IStudentRepository {
    void save(Student student);
    void update(Student student);
    void delete(int id);
    Student findById(int id);
    List<Student> findAll();
    List<Student> searchByName(String name);
}
