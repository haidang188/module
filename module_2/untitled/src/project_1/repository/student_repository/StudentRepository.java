package project_1.repository.student_repository;

import project_1.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static List<Student> students;
    private static int lastId;
    static {
        students = new ArrayList<>();
        students.add(new Student(1, "Nguyen Van A", "nguyenvana@gmail.com",
                LocalDate.parse("2002-01-01"), "C0825L1"));
        students.add(new Student(2, "Nguyen Van B", "nguyenvanb@gmail.com",
                LocalDate.parse("2002-01-01"), "C0825L1"));
        students.add(new Student(3, "Nguyen Van C", "nguyenvanc@gmail.com",
                LocalDate.parse("2002-01-01"), "C0825L1"));
        students.add(new Student(4, "Nguyen Ha Hai Dang", "nguyenhahaidang@gmail.com",
                LocalDate.parse("2002-01-01"), "C0825L1"));
        students.add(new Student(5, "Nguyen Thi D", "nguyenthid@gmail.com",
                LocalDate.parse("2002-01-01"), "C0825L1"));

        lastId = 5;
    }


    @Override
    public void save(Student student) {
        student.setId(++lastId);
        students.add(student);
            }

    @Override
    public void delete(int id) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student != null && student.getId() == id) {
                students.remove(i);
                break;
            }
        }

    }

    @Override
    public void update(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()) {
                students.set(i, student);
                break;
            }
        }

    }

    @Override
    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public List<Student> searchByName(String name) {
        List<Student> result = new ArrayList<>();
        String keyword = name.toLowerCase();
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(keyword)) {
                result.add(student);
            }
        }
        return result;
    }

}
