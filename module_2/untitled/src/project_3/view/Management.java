package project_3.view;

import project_3.model.Car;

import java.util.Scanner;

public class Management {
    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("""
                    1. Thêm mới phương tiện
                    2. Hiển thị phương tiện
                    3. Xóa phương tiện
                    4. Thoát 
                    """);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.exit(0);
            }

        } while (true);
    }

    public static void addVehicle() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("""
                    1. Thêm ô tô
                    2. Thêm xe tải
                    3. Thêm xe máy
                    4. Trỏ về 
                    """);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Car car = addCar();

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    mainMenu();
                    break;
            }
        } while (true);

    }
    public static Car addCar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập biển kiểm soát");
        String lisencePlate = sc.nextLine();
        System.out.println("Nhập hãng sản xuất");
        String manufacturerName = sc.nextLine();
        System.out.println("Nhập năm sản xuất");
        int manufacturerYear = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập số chỗ ngồi");
        int seatCount = sc.nextInt();
        System.out.println("Nhập kiểu xe");
        String vehicleType = sc.nextLine();
        return new Car(lisencePlate, manufacturerName, manufacturerYear, seatCount, vehicleType);

    }
    public static void addTruck() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập biển kiểm soát");
        String lisencePlate = sc.nextLine();
        System.out.println("Nhập hãng sản xuất");
        String manufacturerName = sc.nextLine();
        System.out.println("Nhập năm sản xuất");
        int manufacturerYear = Integer.parseInt(sc.nextLine());
    }

    public static void main(String[] args) {
        Management.mainMenu();
    }
}
