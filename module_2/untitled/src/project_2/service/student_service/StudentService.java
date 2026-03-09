package project_2.service.student_service;

import project_2.model.Student;
import project_2.repository.student_repository.IStudentRepository;
import project_2.repository.student_repository.StudentRepository;

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
    public List<Student> searchByName(String name) {
        return iStudentRepository.searchByName(name);
    }
}
