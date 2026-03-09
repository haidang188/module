package ss_1.bai_tap;

import java.util.Scanner;

public class bai_2 {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so tien USD: ");
        usd = sc.nextDouble();
        double quydoi = usd * 23000;
        System.out.print("Gia tri VND: " + quydoi);
    }
}
