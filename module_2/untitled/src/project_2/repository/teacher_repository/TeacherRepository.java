package project_2.repository.teacher_repository;


import project_2.model.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository implements ITeacherRepository {
    private static List<Teacher> teachers;
    private static int lastId;

    static {
        teachers = new ArrayList<>();
        teachers.add(new Teacher(1, "Nguyen Van A", "nguyenvan@codegym.com",
                LocalDate.parse("1990-01-01"), 2000000));
        teachers.add(new Teacher(2, "Le Van B", "levan@codegym.com",
                LocalDate.parse("1990-01-01"), 3000000));
        teachers.add(new Teacher(3, "Pham Van C", "phamvan@codegym.com",
                LocalDate.parse("1990-01-01"), 5000000));
        teachers.add(new Teacher(4, "Duong Van D", "duongvan@codegym.com",
                LocalDate.parse("1990-01-01"), 6000000));
        teachers.add(new Teacher(5, "Phan Van E", "phanvan@codegym.com",
                LocalDate.parse("1990-01-01"), 8000000));

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
            if (teacher.getId() == teachers.get(i).getId()) {
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
        List<Teacher> reuslt = new ArrayList<>();
        String keyword = name.toLowerCase();
        for (Teacher teacher : teachers) {
            if (teacher.getName().toLowerCase().contains(keyword)) {
                reuslt.add(teacher);
            }
        }
        return reuslt;
    }
}
