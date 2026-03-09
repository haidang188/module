package exam.view;

import exam.controller.ImportedController;
import exam.controller.OfficialController;
import exam.model.Imported;
import exam.model.Official;
import project_2.common.MyValidation;

import java.util.List;
import java.util.Scanner;

public class Management {
    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("""
                    1. Quan ly dien thoai chinh hang
                    2. Quan ly dien thoai xach tay
                    3. Thoat
                    Vui long chon trong menu
                    """);
            int choice = getChoice();
            switch (choice) {
                case 1:
                    officialMenu();
                    break;
                case 2:
                    importedMenu();
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

    public static Official officialMenu() {
        Scanner sc = new Scanner(System.in);
        OfficialController officialController = new OfficialController();
        do {
            System.out.println("""
                    1. Them moi
                    2. Xoa
                    3. Xem danh sach
                    4. Tim kiem
                    5. Thoat
                    Vui long chon trong menu
                    
                    """);
            int choice = getChoice();
            switch (choice) {
                case 1:
                    Official official = inputOfficial();
                    officialController.saveOfficial(official);
                    break;
                case 2:
                    deleteInfoOfficial(officialController);
                    break;
                case 3:
                    officialController.findAll();
                    break;
                case 4:
                    findOfficial(officialController);
                    break;


            }
        } while (true);
    }

    public static Official inputOfficial() {
        Scanner sc = new Scanner(System.in);
        OfficialController officialController = new OfficialController();
        String name;
        while (true) {
            System.out.println("Nhap ten dien thoai:");
            name = sc.nextLine();

            if (name.isEmpty()) {
                System.out.println("Vui long khong bo trong");
                continue;
            }
            if (!MyValidation.isValidName(name)) {
                System.out.println("Ten khong chua ky tu. Vui long nhap lai");
                continue;
            }
            break;
        }
        System.out.println("Nhap gia ban:");
        double price = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap so luong");
        String quantity = sc.nextLine();
        System.out.println("Nhap ten nha san xuat:");
        String company = sc.nextLine();
        System.out.println("Nhap thoi gian bao hanh");
        int period = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap pham vi bao hanh");
        String coverage = sc.nextLine();
        return new Official(name, price, quantity, company, period, coverage);

    }

    public static void deleteInfoOfficial(OfficialController officialController) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ID dien thoai can xoa");
        int id = Integer.parseInt(sc.nextLine());
        Official official = officialController.findById(id);
        if (official != null) {
            System.out.println("Khong tim thay dien thoai");
            return;
        }
        System.out.println("Dien thoai can xoa");
        System.out.println(official);
        System.out.println("Ban co chac chan xoa khong");
        int confirm = getChoice();
        if (confirm == 1) {
            officialController.deleteOfficial(official);
        }
    }

    public static void findOfficial(OfficialController officialController) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap id can tim");
        String keyword = sc.nextLine();
        List<Official> result = officialController.findByName(keyword);
        if (result.isEmpty()) {
            System.out.println("Khong tim thay dien thoai");
            return;
        }
        System.out.println("Ket qua tim thay");
        for (Official official : result) {
            System.out.println(official);
        }
    }

    public static Imported importedMenu() {
        Scanner sc = new Scanner(System.in);
        ImportedController importedController = new ImportedController();
        do {
            System.out.println("""
                    1. Them moi
                    2. Xoa
                    3. Xem danh sach
                    4. Tim kiem
                    5. Thoat
                    Vui long chon trong menu
                    
                    """);
            int choice = getChoice();
            switch (choice) {
                case 1:
                    Imported imported = inputImported();
                    importedController.saveImported(imported);
                    break;
                case 2:
                    deleteInfoImported(importedController);
                    break;
                case 3:
                    importedController.findAll();
                    break;
                case 4:
                    findImported(importedController);
                    break;


            }
        } while (true);

    }
    public static Imported inputImported() {
        Scanner sc = new Scanner(System.in);

        ImportedController importedController = new ImportedController();
        String name;
        while (true) {
            System.out.println("Nhap ten dien thoai:");
            name = sc.nextLine();

            if (name.isEmpty()) {
                System.out.println("Vui long khong bo trong");
                continue;
            }
            if (!MyValidation.isValidName(name)) {
                System.out.println("Ten khong chua ky tu. Vui long nhap lai");
                continue;
            }
            break;
        }
        System.out.println("Nhap gia ban:");
        double price = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap so luong");
        String quantity = sc.nextLine();
        System.out.println("Nhap ten nha san xuat:");
        String company = sc.nextLine();
        System.out.println("Nhap quoc gia xach tay");
        String country = sc.nextLine();
        System.out.println("Nhap trang thai");
        String status = sc.nextLine();
        return new Imported(name, price, quantity, company, country, status);



    }
    public static void deleteInfoImported(ImportedController importedController) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ID dien thoai can xoa");
        int id = Integer.parseInt(sc.nextLine());
        Imported imported = importedController.findById(id);
        if (imported != null) {
            System.out.println("Khong tim thay dien thoai");
            return;
        }
        System.out.println("Dien thoai can xoa");
        System.out.println(imported);
        System.out.println("Ban co chac chan xoa khong");
        int confirm = getChoice();
        if (confirm == 1) {
            importedController.deleteImported(imported);
        }
    }
    public static void findImported(ImportedController importedController) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap id can tim");
        String keyword = sc.nextLine();
        List<Imported> result = importedController.findByName(keyword);
        if (result.isEmpty()) {
            System.out.println("Khong tim thay dien thoai");
            return;
        }
        System.out.println("Ket qua tim thay");
        for (Imported imported : result) {
            System.out.println(imported);
        }
    }
    public static void main(String[] args) {
        Management.mainMenu();
    }
}
