package project_1.view;

import project_1.common.MyValidation;
import project_1.controller.StudentController;
import project_1.controller.TeacherController;
import project_1.model.Student;
import project_1.model.Teacher;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Management {
    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("""
                    1. Quan ly sinh vien
                    2. Quan ly giang vien
                    3. Thoat
                    Vui long chon trong menu
                    """);
            int choice = getChoice();
            switch (choice) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    teacherMenu();
                    break;
                case 3:
                    System.exit(0);
            }
        } while (true);
    }

    private static int getChoice() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            try {
                choice = Integer.parseInt(sc.nextLine());
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so");
            }
        } while (true);
    }

    public static void studentMenu() {
        Scanner sc = new Scanner(System.in);
        StudentController studentController = new StudentController();
        do {
            System.out.println("""
                    1. Hien thi danh sach hoc vien
                    2. Them moi hoc vien
                    3. Sua hoc vien
                    4. Xoa hoc vien
                    5. Tim kiem hoc vien
                    6. Tro ve
                    """);
            int choice = getChoice();
            switch (choice) {
                case 1:
                    studentController.findAll();
                    break;
                case 2:
                    Student student = inputInfoStudent(sc);
                    studentController.saveStudent(student);
                    break;
                case 3:
                    editInfoStudent(studentController);
                    break;
                case 4:
                    deleteInfoStudent(studentController);
                    break;
                case 5: findStudent(studentController);
                    break;
                case 6:
                    return;
            }
        } while (true);
    }
    public static Student inputInfoStudent(Scanner sc) {
//        System.out.println("Nhap ten hoc vien");
//        String name = sc.nextLine();
//        System.out.println("Nhap email hoc vien");
//        String email = sc.nextLine();
//        System.out.println("Nhap ngay sinh hoc vien");
//        String birthday = sc.nextLine();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        LocalDate birthdayDate = LocalDate.parse(birthday, formatter);
//        System.out.println("Nhap lop hoc vien");
//        String className = sc.nextLine();
//        return new Student(name, email, birthdayDate, className);

        String name;
        while (true) {
            System.out.println("Nhap ten hoc vien");
            name = sc.nextLine();

            if (name.isEmpty()) {
                System.out.println("Vui long khong de trong");
                continue;
            }
            if (!MyValidation.isValidName(name)) {
                System.out.println("Ten khong chua ky tu. Vui long nhap lai");
                continue;
            }
            break;
        }
        String email;
        while (true) {
            System.out.println("Nhap email sinh vien");
            email = sc.nextLine().trim();

            if (email.isEmpty()) {
                System.out.println("Vui long khong de trong");
                continue;
            }
            if (!MyValidation.isValidEmail(email)) {
                System.out.println("Email khong dung dinh dang. Vui long nhap lai");
                continue;
            }
            break;
        }

        LocalDate localDate;
        while (true) {
            System.out.println("Nhap ngay sinh");
            String birthday = sc.nextLine().trim();
            if (birthday.isEmpty()) {
                System.out.println("Vui long khong de trong");
                continue;
            }
            if (!MyValidation.isValidFormatBirthday(birthday)) {
                System.out.println("Ngay sinh khong hop le. Vui long nhap lai");
                continue;
            }
            int day = Integer.parseInt(birthday.substring(0, 2));
            int month = Integer.parseInt(birthday.substring(3, 5));
            int year = Integer.parseInt(birthday.substring(6, 10));
            localDate = LocalDate.of(year, month, day);

            if (!MyValidation.isValidAge(localDate, 18, 60)){
                System.out.println("Tuoi tu 18 den 60");
                continue;
            }
            break;
        }
        System.out.println("Nhap lop hoc vien");
        String className = sc.nextLine().trim();
        return new Student(name, email, localDate, className);
    }
    public static void editInfoStudent(StudentController studentController) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ID can sua hoc vien");
        int editId = Integer.parseInt(sc.nextLine());
        Student oldStudent = studentController.findById(editId);
        if (oldStudent == null) {
            System.out.println("Khong tim thay hoc vien voi ID = " + editId);
            return;
        }
        System.out.println("Thong tin sinh vien can sua");
        System.out.println(oldStudent);
        System.out.println("Nhap ten sinh vien moi");
        String name = sc.nextLine();
        System.out.println("Nhap email moi");
        String email = sc.nextLine();
        System.out.println("Nhap ngay sinh moi");
        String birthday = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthdayDate = LocalDate.parse(birthday, formatter);
        System.out.println("Nhap lop hoc vien");
        String className = sc.nextLine();

        Student updatedInfoStudent = new Student(editId, name, email, birthdayDate, className);
        studentController.updateStudent(updatedInfoStudent);
        System.out.println("Cap nhat thong tin thanh cong");
    }
    public static void deleteInfoStudent(StudentController studentController) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ID can xoa hoc vien");
        int id = Integer.parseInt(sc.nextLine());
        Student student = studentController.findById(id);
        if (student == null) {
            System.out.println("Khong tim thay hoc vien");
            return;
        }
        System.out.println("Sinh vien can xoa");
        System.out.println(student);
        System.out.println("Ban co chac chan xoa khong");
        int confirm = getChoice();
        if (confirm == 1) {
            studentController.deleteStudent(student);
        }
    }
    public static void findStudent(StudentController studentController) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten can tim");
        String keyword = sc.nextLine();
        List<Student> result = studentController.findByName(keyword);
        if (result.isEmpty()) {
            System.out.println("Khong tim thay hoc vien");
            return;
        }
        System.out.println("Ket qua tim kiem");
        for (Student student : result) {
            System.out.println(student);
        }
    }

    public static void teacherMenu() {
        Scanner sc = new Scanner(System.in);
        TeacherController teacherController = new TeacherController();
        do {
            System.out.println("""
                    1. Hien thi danh sach hoc vien
                    2. Them moi hoc vien
                    3. Sua hoc vien
                    4. Xoa hoc vien
                    5. Tim kiem hoc vien
                    6. Tro ve
                    """);
            int choice = getChoice();
            switch (choice) {
                case 1:
                    teacherController.findAll();
                    break;
                case 2:
                    Teacher teacher = inputInfoTeacher(sc);
                    teacherController.saveTeacher(teacher);
                    break;
                case 3:
                    editInfoTeacher(teacherController);
                    break;
                case 4:
                    deleteInfoTeacher(teacherController);
                    break;
                case 5:
                    findInfoTeacher(teacherController);
                    break;
                case 6:
                    return;
            }
        } while (true);
    }
    public static Teacher inputInfoTeacher(Scanner sc) {
        System.out.println("Nhap ten giang vien");
        String name = sc.nextLine();
        System.out.println("Nhap email giang vien");
        String email = sc.nextLine();
        System.out.println("Nhap ngay sinh giang vien");
        String birthday = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthdayDate = LocalDate.parse(birthday, formatter);
        System.out.println("Nhap tien luong giang vien");
        Double salary = Double.parseDouble(sc.nextLine());
        return new Teacher(name, email, birthdayDate, salary);
    }
    public static void editInfoTeacher(TeacherController teacherController) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ID giang vien can sua");
        int editId = Integer.parseInt(sc.nextLine());
        Teacher oldTeacher = teacherController.findTeacherById(editId);
        if (oldTeacher == null) {
            System.out.println("Khong tim thay giang vien");
            return;
        }
        System.out.println("Thong tin giang vien can sua");
        System.out.println(oldTeacher);
        System.out.println("Nhap ten giang vien");
        String name = sc.nextLine();
        System.out.println("Nhap email giang vien");
        String email = sc.nextLine();
        System.out.println("Nhap ngay sinh giang vien");
        String birthday = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthdayDate = LocalDate.parse(birthday, formatter);
        System.out.println("Nhap tien luong giang vien");
        Double salary = Double.parseDouble(sc.nextLine());

        Teacher updateInfoTeacher = new Teacher(editId, name, email, birthdayDate, salary);
        teacherController.updateTeacher(updateInfoTeacher);
        System.out.println("Cap nhat thong tin thanh cong");
    }
    public static void deleteInfoTeacher(TeacherController teacherController) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ID can xoa giang vien");
        int id = Integer.parseInt(sc.nextLine());
        Teacher teacher = teacherController.findTeacherById(id);
        if (teacher == null) {
            System.out.println("Khong tim thay giang vien");
            return;
        }
        System.out.println("Giang vien can xoa");
        System.out.println(teacher);
        System.out.println("Ban co chac chan xoa");
        int confirm = getChoice();
        if (confirm == 1) {
            teacherController.deleteTeacher(teacher);
        }
    }
    public static void findInfoTeacher(TeacherController teacherController) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten can tim");
        String keyword = sc.nextLine();
        List<Teacher> result = teacherController.findTeacherByName(keyword);
        if (result.isEmpty()) {
            System.out.println("Khong tim thay giang vien");
            return;
        }
        System.out.println("Ket qua tim kiem");
        for (Teacher teacher : result) {
            System.out.println(teacher);
        }

    }
    public static void main(String[] args) {
        Management.mainMenu();
    }
}
