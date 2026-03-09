package project_2.service.student_service;

import project_2.model.Student;

import java.util.List;

public interface IStudentService {
    void save(Student student);
    void update(Student student);
    void delete(int id);
    Student findById(int id);
    List<Student> findAll();
    List<Student> searchByName(String name);
}
