package ss_3.bai_tap;

import java.util.Scanner;

public class bai_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap kich thuoc ma tran vuong");
        int n = sc.nextInt();

        double[][] matrix = new double[n][n];

        System.out.println("Nhap cac gia tri cua ma tran: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("matrix[" + i + "][" + j + "] = ");
                matrix[i][j] = sc.nextDouble();
            }
        }
//        // Tong duong cheo chinh
//        double sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum += matrix[i][i];
//        }

        // Tong hai duong cheo, bo qua phan tu bi trung
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
            int j = n - 1 - i;
            if (j != i) {
                sum += matrix[i][j];
            }
        }


        System.out.println("Tong duong cheo chinh la: " + sum);
        sc.close();
    }
}
