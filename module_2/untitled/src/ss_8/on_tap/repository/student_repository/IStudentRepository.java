package ss_8.on_tap.repository.student_repository;

import ss_8.on_tap.model.Student;

public interface IStudentRepository {
    void save(Student student);
    void delete(Student student);
    void update(Student student);
    Student findById(int id);
    Student[] findAll();
}
