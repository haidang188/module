package ss_8.on_tap.service.student_service;

import ss_8.on_tap.model.Student;

public interface IStudentService {
    void save(Student student);
    void delete(Student student);
    void update(Student student);
    Student findById(int id);
    Student[] findAll();

}
