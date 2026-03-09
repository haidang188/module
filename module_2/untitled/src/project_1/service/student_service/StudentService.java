package project_1.service.student_service;

import project_1.model.Student;
import project_1.repository.student_repository.IStudentRepository;
import project_1.repository.student_repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepository iStudentRepoditory = new StudentRepository();

    @Override
    public void save(Student student) {
        iStudentRepoditory.save(student);

    }

    @Override
    public void update(Student student) {
        iStudentRepoditory.update(student);

    }

    @Override
    public void delete(int id) {
        iStudentRepoditory.delete(id);
    }

    @Override
    public Student findById(int id) {
        return iStudentRepoditory.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return iStudentRepoditory.findAll();
    }

    @Override
    public List<Student> searchByName(String name) {
        return iStudentRepoditory.searchByName(name);
    }
}
