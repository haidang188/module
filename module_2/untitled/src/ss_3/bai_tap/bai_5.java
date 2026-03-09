package ss_3.bai_tap;

import java.util.Scanner;

public class bai_5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap kich thuoc mang: ");
        int size = sc.nextInt();
        int[] array = new int[size];

        System.out.println("Nhap gia tri cho cac phan tu trong mang: ");
        for (int i = 0; i < size; i++) {
            System.out.print("array[" + i + "] = ");
            array[i] = sc.nextInt();
        }
        int min = array[0];

        for (int i = 1; i < size; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("Gia tri nho nhat trong mang la: " + min);
        sc.close();
    }
}
