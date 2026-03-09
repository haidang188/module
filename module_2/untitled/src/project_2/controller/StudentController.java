package project_2.controller;

import project_2.model.Student;
import project_2.service.student_service.IStudentService;
import project_2.service.student_service.StudentService;

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
    public List<Student> seacrhByName(String name) {
        return iStudentService.searchByName(name);
    }

}
