package project_1.service.student_service;

import project_1.model.Student;
import project_1.repository.student_repository.IStudentRepository;
import project_1.repository.student_repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepository iStudentRepository = new StudentRepository();

    @Override
    public void save(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        iStudentRepository.update(student);
    }

    @Override
    public void delete(int id) {
        iStudentRepository.delete(id);
    }

    @Override
    public Student findById(int id) {
        return iStudentRepository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public List<Student> findByName(String name) {
        return iStudentRepository.findByName(name);
    }
}
