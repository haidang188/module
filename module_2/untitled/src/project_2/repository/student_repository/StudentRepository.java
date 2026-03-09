package project_2.repository.student_repository;

import project_2.io_stream.StudentIOStream;
import project_2.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    private static int lastId;

    static {
        List<Student> students = StudentIOStream.readStudentFromFile();
        if (!students.isEmpty()) {
            lastId = students.get(students.size() - 1).getId();
        } else {
            lastId = 0;
        }

    }

    @Override
    public void save(Student student) {
        student.setId(++lastId);
        StudentIOStream.writeStudentInfoFile(student);


    }

    @Override
    public void update(Student student) {
        List<Student> studentsList = StudentIOStream.readStudentFromFile();
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getId() == student.getId()) {
                studentsList.set(i, student);
                break;
            }
        }

    }

    @Override
    public void delete(int id) {
        List<Student> studentsList = StudentIOStream.readStudentFromFile();
        for (int i = 0; i < studentsList.size(); i++) {
            Student student = studentsList.get(i);
            if (student != null && student.getId() == id) {
                studentsList.remove(i);
                break;
            }
        }
        StudentIOStream.writeListStudentInfoFile(studentsList);

    }

    @Override
    public Student findById(int id) {
        for (Student student : StudentIOStream.readStudentFromFile()) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return StudentIOStream.readStudentFromFile();
    }

    @Override
    public List<Student> searchByName(String name) {
        List<Student> result = new ArrayList<>();
        String keyword = name.toLowerCase();
        for (Student student : StudentIOStream.readStudentFromFile()) {
            if (student.getName().toLowerCase().contains(keyword)) {
                result.add(student);
            }
        }
        return result;
    }
}
