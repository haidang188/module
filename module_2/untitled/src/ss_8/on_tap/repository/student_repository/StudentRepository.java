package ss_8.on_tap.repository.student_repository;

import ss_8.on_tap.model.Student;

import java.time.LocalDate;

public class StudentRepository implements IStudentRepository {
    private static Student[] students;
    static {
        students = new Student[10];
        students[0] = new Student("Dang", "dang@gmail.com",
                LocalDate.parse("2002-01-01"), "C0825L1");
        students[1] = new Student("Nguyen", "dang@gmail.com",
                LocalDate.parse("2002-01-01"), "C0825L1");
        students[2] = new Student("Ha", "dang@gmail.com",
                LocalDate.parse("2002-01-01"), "C0825L1");
        students[3] = new Student("Hai", "dang@gmail.com",
                LocalDate.parse("2002-01-01"), "C0825L1");
    }


    @Override
    public void save(Student student) {
        for (int i = 0; i < students.length; i++) {
            if(students[i] == null) {
                students[i] = student;
                break;
            }
        }

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
        return students;
    }
}
