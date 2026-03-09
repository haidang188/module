package ss_3.bai_tap;

import java.util.Scanner;

public class bai_2 {
    public static void main(String[] args) {
        int[] array = {10, 4, 6, 7, 8, 0, 0, 0, 0};
        int x;
        int index;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap phan tu can them: ");
        x = sc.nextInt();

        System.out.println("Nhap vi tri index can chen: ");
        index = sc.nextInt();

        if (index < 0 || index >= array.length) {
            System.out.print("Khong chen duoc phan tu vao mang");
        } else {
            for (int i = array.length - 1; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = x;

            System.out.print("Mang sau khi chen: ");
            for (int v : array) {
                System.out.print(v + " ");
            }
        }
        sc.close();

    }
}
