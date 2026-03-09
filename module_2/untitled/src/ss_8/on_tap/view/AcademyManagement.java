package ss_8.on_tap.view;

import ss_8.on_tap.controller.StudentController;
import ss_8.on_tap.model.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AcademyManagement {
    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("""
                    1. Quan ly hoc vien
                    2. Quan ly giang vien
                    3. Thoat
                    Vui long chon trong menu""");
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


    public static void studentMenu() {
        Scanner sc = new Scanner(System.in);
        StudentController studentController = new StudentController();
        int choice;

        do {
            System.out.println("""
                1. Hien thi hoc vien
                2. Them moi hoc vien
                3. Chinh sua
                4. Xoa
                5. Tim kiem
                6. Tro ve
                Vui long chon trong menu""");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    studentController.findAll();
                    break;
                    case 2:
                        Student student = inputStudentInformation();
                        studentController.saveStudent(student);
                        break;
                case 6:
                    return;
            }
        } while (true);

    }
    public static Student inputStudentInformation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên học viên: ");
        String name = sc.nextLine();
        System.out.println("Nhập email học viên: ");
        String email = sc.nextLine();
        System.out.println("Nhập ngày sinh học viên: ");
        String birthday = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(birthday, formatter);
        System.out.println("Nhập lớp học viên: ");
        String className = sc.nextLine();
        return new Student(name, email, localDate, className);
    }


    public static void teacherMenu() {
        System.out.println("""
                1. Hien thi hoc vien
                2. Them moi hoc vien
                3. Chinh sua
                4. Xoa 
                5. Tim kiem
                6. Tro ve
                Vui long chon trong menu""");
    }

    public static void main(String[] args) {
        AcademyManagement.mainMenu();
    }
}
