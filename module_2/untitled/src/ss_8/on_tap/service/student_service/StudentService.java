package ss_8.on_tap.service.student_service;


import ss_8.on_tap.model.Student;
import ss_8.on_tap.repository.student_repository.IStudentRepository;
import ss_8.on_tap.repository.student_repository.StudentRepository;

public class StudentService implements IStudentService {
    private IStudentRepository iStudentRepository = new StudentRepository();


    @Override
    public void save(Student student) {
        iStudentRepository.save(student);

    }

    @Override
    public void delete(Student student) {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public Student[] findAll() {
        return iStudentRepository.findAll();
    }
}
