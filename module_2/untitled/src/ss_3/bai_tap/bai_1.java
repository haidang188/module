package ss_3.bai_tap;
// Xóa phần tử trong mảng
import java.util.Scanner;

public class bai_1 {
    public static void main(String[] args) {
        int[] array = {10, 4, 16, 7, 8, 6, 0, 0, 0, 0};
        int x;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap phan tu can xoa: ");
        x = sc.nextInt();

        int index_del = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                index_del = i;
                break;
            }
        }
        if (index_del == -1) {
            System.out.println("Khong tim thay phan tu " + x + " trong mang ");
        } else {
            System.out.println("Tim thay phan tu " + x + " o vi tri:  " + index_del);

            for (int i = index_del; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length - 1] = 0;

            System.out.println("Mang sau khi xoa: ");
            for (int v : array) {
                System.out.print(v + " ");
            }
            System.out.println();

        }
        sc.close();


    }
}
