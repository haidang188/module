package project_1.controller;

import project_1.model.Student;
import project_1.service.student_service.IStudentService;
import project_1.service.student_service.StudentService;

import java.util.List;

public class StudentController {
    private IStudentService iStudentService = new StudentService();

    public void findAll() {
        List<Student> students = iStudentService.findAll();
        for (Student student : students) {
            if (student == null) {
                return;
            }
            System.out.println(student);
        }
    }

    public void saveStudent(Student student) {
        iStudentService.save(student);
    }
    public Student findById(int id) {
        return iStudentService.findById(id);
    }
    public void updateStudent(Student student) {
        iStudentService.update(student);
    }
    public void deleteStudent(Student teacher) {
        iStudentService.delete(teacher.getId());
    }
   public List<Student> searchByName(String name) {
        return iStudentService.searchByName(name);
   }
}
