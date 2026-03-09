package ss_3.bai_tap;

import java.util.Scanner;

public class bai_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap so hang: ");
        int rows = sc.nextInt();

        System.out.println("Nhap so cot: ");
        int cols = sc.nextInt();

        double[][] matrix = new double[rows][cols];
        System.out.println("Nhap gia tri cho ma tran: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("matrix[" + i + "][" + j + "] = ");
                matrix[i][j] = sc.nextDouble();
            }
        }
        System.out.println("Nhap cot can tinh tong");
        int column = sc.nextInt();

        double sum = 0;
        for (int i = 0; i < rows; i++) {
            sum += matrix[i][column];
        }
        System.out.println("Tong cua cot " + column + " la: " + sum);
    }
}
