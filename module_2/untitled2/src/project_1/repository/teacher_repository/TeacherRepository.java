package project_1.repository.teacher_repository;

import project_1.io_stream.TeacherIOStream;
import project_1.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepository implements ITeacherRepository {
    private static int lastId;
    static {
        List<Teacher> teachers = TeacherIOStream.readTeacherFromFile();
        if (!teachers.isEmpty()) {
            lastId = teachers.get(teachers.size() - 1).getId();
        } else {
            lastId = 0;
        }
    }
    @Override
    public void save(Teacher teacher) {
        teacher.setId(++lastId);
        TeacherIOStream.writeTeacherInfoFile(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        List<Teacher> teachersList = TeacherIOStream.readTeacherFromFile();
        for (int i = 0; i < teachersList.size(); i++) {
            if (teachersList.get(i).getId() == teacher.getId()) {
                teachersList.set(i, teacher);
                break;
            }
        }
        TeacherIOStream.writeListTeacherInfoFile(teachersList);
    }

    @Override
    public void delete(int id) {
        List<Teacher> teachersList = TeacherIOStream.readTeacherFromFile();
        for (int i = 0; i < teachersList.size(); i++) {
            Teacher teacher = teachersList.get(i);
            if (teacher != null && teacher.getId() == id) {
                teachersList.remove(i);
                break;
            }
        }
        TeacherIOStream.writeListTeacherInfoFile(teachersList);
    }

    @Override
    public List<Teacher> findAll() {
        return TeacherIOStream.readTeacherFromFile();
    }

    @Override
    public Teacher findById(int id) {
        for (Teacher teacher : TeacherIOStream.readTeacherFromFile()) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }

    @Override
    public List<Teacher> findByName(String name) {
        List<Teacher> result = new ArrayList<>();
        String keyword = name.toLowerCase();
        for (Teacher teacher : TeacherIOStream.readTeacherFromFile()) {
            if (teacher.getName().toLowerCase().contains(keyword)) {
                result.add(teacher);
            }
        }
        return result;
    }
}
