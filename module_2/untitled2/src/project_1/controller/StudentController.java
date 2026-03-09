package project_1.controller;

import project_1.model.Student;
import project_1.service.student_service.IStudentService;
import project_1.service.student_service.StudentService;

import java.util.List;

public class StudentController {
    private IStudentService iStudentService = new StudentService();

    public void findAll() {
        for (Student student : iStudentService.findAll()) {
            System.out.println(student);
        }
    }
    public void saveStudent(Student student) {
        iStudentService.save(student);
    }
    public void deleteStudent(Student student) {
        iStudentService.delete(student.getId());
    }
    public void updateStudent(Student student) {
        iStudentService.update(student);
    }
    public Student findById(int id) {
        return iStudentService.findById(id);
    }
    public List<Student> findByName(String name) {
        return iStudentService.findByName(name);
    }

}

