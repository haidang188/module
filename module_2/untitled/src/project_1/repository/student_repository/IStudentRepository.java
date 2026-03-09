package project_1.repository.student_repository;


import project_1.model.Student;

import java.util.List;

public interface IStudentRepository {
    void save(Student student);
    void delete(int id);
    void update(Student student);
    Student findById(int id);
    List<Student> findAll();
    List<Student> searchByName(String name);



}
