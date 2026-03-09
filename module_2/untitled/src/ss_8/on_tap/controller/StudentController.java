package ss_8.on_tap.controller;

import ss_8.on_tap.model.Student;
import ss_8.on_tap.service.student_service.IStudentService;
import ss_8.on_tap.service.student_service.StudentService;

public class StudentController {
    private IStudentService iStudentService = new StudentService();

    public void findAll() {
        Student[] students = iStudentService.findAll();
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
}
