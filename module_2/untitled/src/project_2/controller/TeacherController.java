package project_2.controller;

import project_2.model.Teacher;
import project_2.service.teacher_service.ITeacherService;
import project_2.service.teacher_service.TeacherService;

import java.util.List;

public class TeacherController {
    private ITeacherService iTeacherService = new TeacherService();

    public void findAll() {
        List<Teacher> teachers = iTeacherService.findAll();
        for (Teacher teacher : teachers) {
            if (teacher == null) {
                return;
            }
            System.out.println(teacher);
        }
    }
    public void saveTeacher(Teacher teacher) {
        iTeacherService.save(teacher);
    }
    public void deleteTeacher(Teacher teacher) {
        iTeacherService.delete(teacher.getId());
    }
    public void updateTeacher(Teacher teacher) {
        iTeacherService.update(teacher);
    }
    public Teacher findById(int id) {
        return iTeacherService.findById(id);
    }
    public List<Teacher> searchByName(String name) {
        return iTeacherService.searchByName(name);
    }
}
