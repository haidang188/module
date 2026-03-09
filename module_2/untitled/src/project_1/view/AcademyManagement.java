package project_1.view;

import project_1.controller.StudentController;
import project_1.controller.TeacherController;
import project_1.model.Student;
import project_1.model.Teacher;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class AcademyManagement {
    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("""
                    1. Quản lý học viên
                    2. Quản lý giảng viên
                    3. Thoát
                    Vui lòng chọn trong menu
                    """);
            choice = Integer.parseInt(sc.nextLine());
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

    private static void studentMenu() {
        Scanner sc = new Scanner(System.in);
        StudentController studentController = new StudentController();
        int choice;
        do {
            System.out.println("""
                    1. Hiển thị danh sách học viên
                    2. Thêm mới học viên
                    3. Sửa học viên
                    4. Xóa học viên
                    5. Tìm kiếm học viên
                    6. Trở về 
                    """);
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    studentController.findAll();
                    break;
                case 2:
                    Student student = inputStudent();
                    studentController.saveStudent(student);
                    break;
                case 3:
                    editStudent(studentController);
                    break;
                case 4:
                    deleteStudent(studentController);
                    break;
                case 5:
                    searchStudentByName(studentController);
                    break;
                case 6:
                    return;
            }
        } while (true);

    }

    public static Student inputStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên sinh viên: ");
        String name = sc.nextLine();
        System.out.println("Nhập email sinh viên: ");
        String email = sc.nextLine();
        System.out.println("Nhập ngày sinh của sinh viên:");
        String birthday = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(birthday, formatter);
        System.out.println("Nhập lớp của sinh viên: ");
        String className = sc.nextLine();
        return new Student(name, email, localDate, className);

    }

    public static void editStudent(StudentController studentController) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID sinh viên cần sửa: ");
        int editId = Integer.parseInt(sc.nextLine());
        Student oldStudent = studentController.findById(editId);
        if (oldStudent == null) {
            System.out.println("Không tìm thấy sinh viên với ID = " + editId);
            return;
        }
        System.out.println("Thông tin hiện tại: ");
        System.out.println(oldStudent);

        System.out.println("Nhập tên mới: ");
        String name = sc.nextLine();
        System.out.println("Nhập email mới: ");
        String email = sc.nextLine();
        System.out.println("Nhập ngày sinh mới:");
        String birthday = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(birthday, formatter);
        System.out.println("Nhập lớp của sinh viên: ");
        String className = sc.nextLine();
        Student updatedStudent = new Student(editId, name, email, localDate, className);

        studentController.updateStudent(updatedStudent);
        System.out.println("Cập nhật thông tin sinh viên thành công!");

    }

    public static void deleteStudent(StudentController studentController) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID cần xóa: ");
        int id = Integer.parseInt(sc.nextLine());

        Student student = studentController.findById(id);
        if (student == null) {
            System.out.println("Không tìm thấy sinh viên");
            return;
        }
        System.out.println("Sinh viên cần xóa: ");
        System.out.println(student);
        System.out.println("Bạn có chắc chắn xóa không?");
        int corfirm = Integer.parseInt(sc.nextLine());
        if (corfirm == 1) {
            studentController.deleteStudent(student);
        }



    }

    public static void searchStudentByName(StudentController studentController) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên cần tìm: ");
        String keyword = sc.nextLine();

        List<Student> result = studentController.searchByName(keyword);

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên");
            return;
        }
        System.out.println("Kết quả tìm kiếm");
        for (Student student : result) {
            System.out.println(student);
        }


    }

    public static void teacherMenu() {
        Scanner sc = new Scanner(System.in);
        TeacherController teacherController = new TeacherController();
        int choice;

        do {
            System.out.println("""
                    1. Hiển thị danh sách giảng viên
                    2. Thêm mới giảng viên
                    3. Sửa giảng viên
                    4. Xóa giảng viên
                    5. Tìm kiếm giảng viên
                    6. Trở về
                    """);
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    teacherController.findAll();
                    break;
                case 2:
                    Teacher teacher = inputTeacherInformation();
                    teacherController.saveTeacher(teacher);
                    break;
                case 3:
                    editTeacher(teacherController);
                    break;
                case 4:
                    deleteTeacher(teacherController);
                    break;
                case 5:
                    searchTeacherByName(teacherController);
                    break;
                case 6:
                    return;
            }

        } while (true);

    }

    public static Teacher inputTeacherInformation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên giảng viên: ");
        String name = sc.nextLine();
        System.out.println("Nhập email giảng viên: ");
        String email = sc.nextLine();
        System.out.println("Nhập ngày sinh giảng viên: ");
        String birthday = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(birthday, formatter);
        System.out.println("Nhập tiền lương giảng viên: ");
        double salary = Double.parseDouble(sc.nextLine());
        return new Teacher(name, email, localDate, salary);
    }

    public static void editTeacher(TeacherController teacherController) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID giảng viên cần sửa: ");
        int editId = Integer.parseInt(sc.nextLine());
        Teacher oldTeacher = teacherController.findById(editId);
        if (oldTeacher == null) {
            System.out.println("Không tồn tại giảng viên với ID " + editId);
            return;
        }
        System.out.println("Thông tin hiện tại: ");
        System.out.println(oldTeacher);
        System.out.println("Nhập tên giảng viên");
        String name = sc.nextLine();
        System.out.println("Nhập email giảng viên");
        String email = sc.nextLine();
        System.out.println("Nhập ngày sinh giảng viên");
        String birthday = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(birthday, formatter);
        System.out.println("Nhập tiền lương giảng viên");
        double salary = Double.parseDouble(sc.nextLine());

        Teacher updateTeacher = new Teacher(editId, name, email, localDate, salary);
        teacherController.updateTeacher(updateTeacher);
        System.out.println("Cập nhật thông tin giảng viên thành công");

    }

    public static void deleteTeacher(TeacherController teacherController) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID giảng viên cần xóa");
        int id = Integer.parseInt(sc.nextLine());
        Teacher teacher = teacherController.findById(id);
        if (teacher == null) {
            System.out.println("Không tìm thấy giảng viên");
            return;
        }
        System.out.println("Giảng viên cần xóa");
        System.out.println(teacher);
        System.out.println("Bạn có chắc chắn xóa không");
        int confirm = Integer.parseInt(sc.nextLine());
        if (confirm == 1) {
            teacherController.deleteTeacher(teacher);
        }
    }

    public static void searchTeacherByName(TeacherController teacherController) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên cần tìm: ");
        String keyword = sc.nextLine();

        List<Teacher> result = teacherController.searchByName(keyword);
        if (result.isEmpty()) {
            System.out.println("Không tìm thấy giảng viên");
        }
        System.out.println("Kết quả tìm kiếm: ");
        for (Teacher teacher : result) {
            System.out.println(teacher);
        }

    }

    public static void main(String[] args) {
        AcademyManagement.mainMenu();
    }
}
