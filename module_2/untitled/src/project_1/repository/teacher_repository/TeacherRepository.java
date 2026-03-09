package project_1.repository.teacher_repository;

import project_1.model.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository implements ITeacherRepository {
    private static List<Teacher> teachers;
    private static int lastId;
    static {
        teachers = new ArrayList<>();
        teachers.add(new Teacher(1, "Nguyen Van Nam", "nguyenvannam@gmail.com",
                LocalDate.parse("1990-01-01"), 1500000));
        teachers.add(new Teacher(2, "Nguyen Van An", "nguyenvanan@gmail.com",
                LocalDate.parse("1989-01-01"), 2000000));
        teachers.add(new Teacher(3, "Nguyen Van Tuan", "nguyenvantuan@gmail.com",
                LocalDate.parse("1995-01-01"), 2500000));
        teachers.add(new Teacher(4, "Nguyen Van Anh", "nguyenvananh@gmail.com",
                LocalDate.parse("1983-01-01"), 3000000));
        teachers.add(new Teacher(5, "Nguyen Van Dang", "nguyenvandang@gmail.com",
                LocalDate.parse("1970-01-01"), 3500000));
        lastId = 5;
    }

    @Override
    public void save(Teacher teacher) {
        teacher.setId(++lastId);
        teachers.add(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == teacher.getId()) {
                teachers.set(i, teacher);
                break;
            }
        }

    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            Teacher teacher = teachers.get(i);
            if (teacher != null && teacher.getId() == id) {
                teachers.remove(i);
                break;
            }
        }
    }

    @Override
    public Teacher findById(int id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
            return null;
    }

    @Override
    public List<Teacher> findAll() {
        return teachers;
    }

    @Override
    public List<Teacher> searchByName(String name) {
        List<Teacher> result = new ArrayList<>();
        String keyword = name.toLowerCase();
        for (Teacher teacher : teachers) {
            if (teacher.getName().toLowerCase().contains(keyword)) {
                result.add(teacher);
            }
        }
        return result;
    }
}
